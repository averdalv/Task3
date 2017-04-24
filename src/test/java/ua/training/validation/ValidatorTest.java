package ua.training.validation;

import org.junit.Assert;
import org.junit.Test;
import ua.training.controller.validation.Validator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValidatorTest {
    @Test
    public void testValidRegExpName() throws IOException {
        InputStream inputStreamRegExp = new FileInputStream("src/main/resources/regexp.properties");
        Properties regExpProperties=new Properties();
        regExpProperties.load(inputStreamRegExp);
        Validator validator =new Validator(null,null,null);
        String name = "Ihor";
        Assert.assertTrue(validator.isValid(name,regExpProperties.getProperty("nameRegExp")));
    }
    @Test
    public void testValidRegExpMail() throws IOException {
        InputStream inputStreamRegExp = new FileInputStream("src/main/resources/regexp.properties");
        Properties regExpProperties=new Properties();
        regExpProperties.load(inputStreamRegExp);
        Validator validator =new Validator(null,null,null);
        String name = "aaa@mail.com";
        Assert.assertTrue(validator.isValid(name,regExpProperties.getProperty("emailRegExp")));
    }
    @Test
    public void testInValidRegExpMail() throws IOException {
        InputStream inputStreamRegExp = new FileInputStream("src/main/resources/regexp.properties");
        Properties regExpProperties=new Properties();
        regExpProperties.load(inputStreamRegExp);
        Validator validator =new Validator(null,null,null);
        String name = "aaamail.com";
        Assert.assertFalse(validator.isValid(name,regExpProperties.getProperty("emailRegExp")));
    }
}
