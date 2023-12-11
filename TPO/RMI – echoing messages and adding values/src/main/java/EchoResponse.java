import java.io.Serializable;

public class EchoResponse implements Serializable {
    private String echoMessage;

    public EchoResponse(String echoMessage) {
        this.echoMessage = echoMessage;
    }

    public String getEchoMessage() {
        return echoMessage;
    }
}

