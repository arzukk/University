package Exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainsetException extends Exception {

    public TrainsetException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainsetException(String message) {
        super(message);
    }

    public TrainsetException(Throwable cause) {
        super(cause);
    }
}
