import java.io.Serializable;

public class AddResponse implements Serializable {
    private double sum;

    public AddResponse(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }
}
