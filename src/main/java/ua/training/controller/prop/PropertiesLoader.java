package ua.training.controller.prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties getProperties(String propertyFileName) {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(propertyFileName)) {
            properties.load(inputStream);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return properties;
    }
}

