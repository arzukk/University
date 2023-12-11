package Exception;

public class CarTypeException extends Exception {
    public CarTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarTypeException(String message) {
        super(message);
    }

    public CarTypeException(Throwable cause) {
        super(cause);
    }
}
