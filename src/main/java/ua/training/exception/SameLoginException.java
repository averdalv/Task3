package ua.training.exception;

public class SameLoginException extends RuntimeException {
    public SameLoginException(String message) {
        super(message);
    }
    public SameLoginException() {
        super("Ures with this login already exists");
    }

}
