package ua.training.controller;

import java.lang.reflect.Field;

import ua.training.GlobalConst;
import ua.training.controller.validation.FieldAccessor;
import ua.training.controller.validation.Validator;
import ua.training.exception.SameLoginException;
import ua.training.model.NotebookEntry;
import ua.training.view.View;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Controller {
    Scanner scanner;
    NotebookEntry entry;
    View view;
    public Controller(Scanner scanner, NotebookEntry entry,View view) {
        this.scanner = scanner;
        this.entry = entry;
        this.view = view;
    }
    public void processUser() {
        try {
            Validator userInputValidator = new Validator(view,scanner,entry);
            this.entry = userInputValidator.getValidatedNotebookEntry();
            printEntry();
        }
        catch (IllegalAccessException illegalAccessEx) {
            System.err.println(illegalAccessEx.getMessage());
        }
    }
    public void printEntry() throws IllegalAccessException{
        FieldAccessor accessor = new FieldAccessor(entry,entry.getClass());
        Field []fields = accessor.getFields();
        for(Field field:fields) {
            Object value = accessor.getField(field.getName());
            if(field.getType()== GregorianCalendar.class)continue;
            view.printMessage(view.concatenateMessages(field.getName(), GlobalConst.COLON,value.toString()));
        }
    }
}
