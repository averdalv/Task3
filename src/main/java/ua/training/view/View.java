package ua.training.view;

public class View {
 public void printMessage(String message) {
     System.out.println(message);
 }
 public String concatenateMessages(String ...messages) {
     StringBuilder concatenatedMessage = new StringBuilder();
     for(String message:messages) {
        concatenatedMessage.append(message);
     }
     return concatenatedMessage.toString();
 }
}
