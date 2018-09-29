package training_day4.homework;

public class CustomSquareRootException extends Exception {

    private String messageSquareRootInvalid;
    public CustomSquareRootException() {
        messageSquareRootInvalid= "Square Root Invalid";
    }

    public CustomSquareRootException(String message) {
        super(message);
        messageSquareRootInvalid= "Square Root Invalid";
    }

    public CustomSquareRootException(String message, Throwable cause) {
        super(message, cause);
        messageSquareRootInvalid= "Square Root Invalid";
    }

    public CustomSquareRootException(Throwable cause) {
        super(cause);
        messageSquareRootInvalid= "Square Root Invalid";
    }

    @Override
    public String toString() {
        return "CustomSquareRootException{}->"+" "+messageSquareRootInvalid;
    }
}
