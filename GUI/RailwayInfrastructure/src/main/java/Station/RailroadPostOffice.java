package Station;
import lombok.*;
import java.util.concurrent.atomic.AtomicLong;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RailroadPostOffice {
    private String name;
    private String address;
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
    private int numEmployees;
    private boolean isOpen;

    public RailroadPostOffice(String name){
        this.name = name;
    }

    public void open() {
        isOpen = true;
        System.out.println(name + " is now open for business.");
    }

    public void close() {
        isOpen = false;
        System.out.println(name + " is now closed.");
    }

    @Override
    public String toString() {
        return name;
    }
}
