package ua.training.controller.validation;

import java.lang.reflect.Field;

public class FieldAccessor {
    private Object managedObject;
    private Class managedClass;

    public FieldAccessor(Object managedObject, Class managedClass) {

        this.managedObject = managedObject;
        this.managedClass = managedClass;
    }

    /**
    * @return private fields of this class
    * */
    public Field[] getFields() {
        return managedClass.getDeclaredFields();
    }

    private Field getDeclaredFieldByNameAndSetAccessible (String fieldName) {

        Field field = null;
        try{

            field = managedClass.getDeclaredField(fieldName);
            field.setAccessible(true);

        }
        catch (NoSuchFieldException noFieldException) {
            System.err.println(noFieldException.getMessage());
        }
        return field;
    }
    public void setField(String fieldName, Object value) throws IllegalAccessException{

            Field field = getDeclaredFieldByNameAndSetAccessible(fieldName);
            field.set(managedObject, value);

    }

    /**
     *
     * @param fieldName name of field
     * @return value of this field
     */
    public Object getField(String fieldName) throws IllegalAccessException{
            Field field = getDeclaredFieldByNameAndSetAccessible(fieldName);
            return field.get(managedObject);

    }
}