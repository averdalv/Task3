package ua.training.controller.validation;

import ua.training.GlobalConst;
import ua.training.controller.DataReader;
import ua.training.controller.prop.PropertiesLoader;
import ua.training.exception.SameLoginException;
import ua.training.model.Address;
import ua.training.model.DataBaseMock;
import ua.training.model.Name;
import ua.training.model.NotebookEntry;
import ua.training.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Scanner;

public class Validator {
    private NotebookEntry entry;
    private Scanner scanner;
    private View view;
    private Properties entryMatchedRegExpProperties;
    private Properties regExpProperties;
    DataReader reader;
    public Validator(View view, Scanner scanner,NotebookEntry entry) {
        this.view = view;
        this.scanner = scanner;
        this.entry = entry;
        reader = new DataReader(scanner,view);
        entryMatchedRegExpProperties = PropertiesLoader.getProperties("src/main/resources/regexpmodel.properties");
        regExpProperties = PropertiesLoader.getProperties("src/main/resources/regexp.properties");
    }

    /**
     *
     * @param fieldValue value to check
     * @param regExp regular expression
     * @return whether this value is suitable for regExp
     */
    public boolean isValid(String fieldValue, String regExp) {
        return fieldValue.matches(regExp);
    }
    public Address getValidatedAddress() throws IllegalAccessException {
        Address address = new Address();
        FieldAccessor accessor = new FieldAccessor(address,address.getClass());
        setValidatedData(accessor);
        return address;
    }
    public Name getValidatedName() throws IllegalAccessException {
        Name name = new Name();
        FieldAccessor accessor = new FieldAccessor(name,name.getClass());
        setValidatedData(accessor);
        return name;
    }
    public NotebookEntry getValidatedNotebookEntry() throws IllegalAccessException
    {
        FieldAccessor accessor = new FieldAccessor(entry,entry.getClass());
        Field[] fields = accessor.getFields();
        for(Field field:fields) {
            String fieldName = field.getName();
            if(field.getType()==Address.class)accessor.setField(fieldName,getValidatedAddress());
            else if(field.getType()==Name.class)accessor.setField(fieldName,getValidatedName());
            else if(field.getType()== GregorianCalendar.class)accessor.setField(fieldName,new GregorianCalendar());
            else accessor.setField(fieldName,getValidatedString(fieldName));
        }
        validateSkypeLogin(entry.getSubscriberSkypeLogin(),GlobalConst.CHECK_VARIABLE_NAME);
        return entry;
    }
    public void validateSkypeLogin(String skypeLogin,String fieldName) {
        try {
            entry.setSubscriberSkypeLogin(skypeLogin);
            entry.checkUniqueSkypeLogin(DataBaseMock.TEST_LOGIN1);
        }
        catch(SameLoginException loginEx) {
            view.printMessage(GlobalConst.SAME_LOGIN);
            validateSkypeLogin(getValidatedString(fieldName),fieldName);
        }

    }
    /**
     *
     * @exception IllegalAccessException
     * @param accessor accessor for setting values
     */
    private void setValidatedData(FieldAccessor accessor) throws IllegalAccessException{
        Field[] fields = accessor.getFields();
        for(Field field:fields) {
            String fieldName = field.getName();
            accessor.setField(fieldName,getValidatedString(fieldName));
        }
    }

    /**
     *
     * @param fieldName name of field that should be entered
     * @return value that has been gotten from user
     */
    public String getValidatedString(String fieldName) {
        while(true) {
            String lineFromUser=reader.getValueFromUser(fieldName);
            String regExpForFieldName = entryMatchedRegExpProperties.getProperty(fieldName);
            String regExpForField = regExpProperties.getProperty(regExpForFieldName);
            if(!isValid(lineFromUser,regExpForField)) {
                view.printMessage(GlobalConst.WRONG_INPUT);
            }
            else {
                return lineFromUser;
            }
        }
    }


}
