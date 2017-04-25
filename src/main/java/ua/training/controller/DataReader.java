package ua.training.controller;

import ua.training.GlobalConst;
import ua.training.controller.prop.PropertiesLoader;
import ua.training.view.View;
import java.util.Properties;
import java.util.Scanner;

public class DataReader {
    private View view;
    private Scanner scanner;
    private Properties viewProperties;
    private Properties viewExampleProperties;
    public DataReader(Scanner scanner,View view) {
        this.scanner = scanner;
        this.view = view;
        viewProperties = PropertiesLoader.getProperties("src/main/resources/view.properties");
        viewExampleProperties = PropertiesLoader.getProperties("src/main/resources/viewexamples.properties");
    }

    public String getValueFromUser(String fieldName) {
        view.printMessage(view.concatenateMessages(
                GlobalConst.INPUT, GlobalConst.SPACE,
                viewProperties.getProperty(fieldName),GlobalConst.LEFT_PARENTHESIS,
                GlobalConst.EG, GlobalConst.COLON,GlobalConst.SPACE,
                viewExampleProperties.getProperty(fieldName),GlobalConst.RIGHT_PARENTHESIS));
        return scanner.nextLine();
    }
}
