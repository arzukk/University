package Exception;

public class RailroadHazardException extends Throwable {
    String message2;
    String s1;
    long id;
    public RailroadHazardException(String message, Throwable cause) {
        super(message, cause);
    }

    public RailroadHazardException(String message, String message2) {
        super(message);
        this.message2 = message2;
    }

    public RailroadHazardException(String message) {
        super(message);
    }

    public RailroadHazardException(Throwable cause) {
        super(cause);
    }

    public RailroadHazardException(String s, String s1, long id) {
        super(s);
        this.s1 = s1;
        this.id = id;
    }
}
