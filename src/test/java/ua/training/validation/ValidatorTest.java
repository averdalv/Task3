package ua.training.validation;

import org.junit.Assert;
import org.junit.Test;
import ua.training.controller.prop.PropertiesLoader;
import ua.training.controller.validation.Validator;
import java.io.IOException;
import java.util.Properties;

public class ValidatorTest {
    @Test
    public void testValidRegExpName() throws IOException {
        Properties regExpProperties= PropertiesLoader.getProperties("src/main/resources/regexp.properties");
        Validator validator =new Validator(null,null,null);
        String name = "Ihor";
        Assert.assertTrue(validator.isValid(name,regExpProperties.getProperty("nameRegExp")));
    }
    @Test
    public void testValidRegExpMail() throws IOException {
        Properties regExpProperties= PropertiesLoader.getProperties("src/main/resources/regexp.properties");
        Validator validator =new Validator(null,null,null);
        String name = "aaa@mail.com";
        Assert.assertTrue(validator.isValid(name,regExpProperties.getProperty("emailRegExp")));
    }
    @Test
    public void testInValidRegExpMail() throws IOException {
        Properties regExpProperties= PropertiesLoader.getProperties("src/main/resources/regexp.properties");
        Validator validator =new Validator(null,null,null);
        String name = "aaamail.com";
        Assert.assertFalse(validator.isValid(name,regExpProperties.getProperty("emailRegExp")));
    }
}
