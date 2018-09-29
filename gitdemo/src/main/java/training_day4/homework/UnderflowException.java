package training_day4.homework;

public class UnderflowException extends Exception{
    private String message;

    public UnderflowException() {
        this.message="The value is less than Integer.MIN_VALUE";
    }

    public UnderflowException(String message) {
        super(message);
    }

    public UnderflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnderflowException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "UnderflowException{" +
                "message='" + message + '\'' +
                '}';
    }
}
