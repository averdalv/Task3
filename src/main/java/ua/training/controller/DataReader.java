package ua.training.controller;

import ua.training.GlobalConst;
import ua.training.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class DataReader {
    private View view;
    private Scanner scanner;
    private Properties viewProperties;
    private Properties viewExampleProperties;
    public DataReader(Scanner scanner,View view) throws IOException{
        this.scanner = scanner;
        this.view = view;
        InputStream inputStreamView =  new FileInputStream("src/main/resources/view.properties");
        viewProperties = new Properties();
        viewExampleProperties = new Properties();
        viewProperties.load(inputStreamView);
        InputStream inputStreamViewExample =  new FileInputStream("src/main/resources/viewexamples.properties");
        viewExampleProperties.load(inputStreamViewExample);
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
