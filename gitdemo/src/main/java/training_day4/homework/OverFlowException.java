package training_day4.homework;

public class OverFlowException extends Exception{
    private String message;
    public OverFlowException() {
        message="Integer max value exceeded";
    }

    public OverFlowException(String message) {
        super(message);
        this.message="Integer max value exceeded";
    }

    public OverFlowException(String message, Throwable cause) {
        super(message, cause);
        this.message="Integer max value exceeded";
    }

    public OverFlowException(Throwable cause) {
        super(cause);
        message="Integer max value exceeded";
    }

    @Override
    public String toString() {
        return "OverFlowException{" +
                "message='" + message + '\'' +
                '}';
    }
}
