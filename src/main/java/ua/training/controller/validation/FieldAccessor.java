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

    public void setField(String fieldName, Object value) {
        try {

            Field field = managedClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(managedObject, value);


        } catch (NoSuchFieldException exception) {
            throw new RuntimeException("No such field: " + fieldName);
        } catch (IllegalAccessException exception) {
            throw new RuntimeException("Illegal access to field: " + fieldName);
        }
    }

    /**
     *
     * @param fieldName name of field
     * @return value of this field
     */
    public Object getField(String fieldName) {
        try {
            Field field = managedClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(managedObject);

        } catch (NoSuchFieldException exception) {
            throw new RuntimeException("No such field: " + fieldName);
        } catch (IllegalAccessException exception) {
            throw new RuntimeException("Illegal access to field: " + fieldName);
        }

    }
}