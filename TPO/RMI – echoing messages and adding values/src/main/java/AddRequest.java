import java.io.Serializable;
import lombok.*;

@Getter
class AddRequest implements Serializable {
    int num1;
    int num2;

    AddRequest(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
