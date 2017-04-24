package ua.training;

import ua.training.controller.Controller;
import ua.training.model.NotebookEntry;
import ua.training.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String []args) throws IOException{
        NotebookEntry entry = new NotebookEntry();
        View view = new View();
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(scanner,entry,view);
        controller.processUser();
    }
}