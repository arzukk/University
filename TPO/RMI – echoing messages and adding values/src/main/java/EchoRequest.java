import java.io.Serializable;
import lombok.*;

@Getter
class EchoRequest implements Serializable {
    String message;

    EchoRequest(String message) {
        this.message = message;
    }
}