package Mechanics2;
import Enums.HeavyFreightType;
import Mechanics.RailroadCar;
import lombok.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HeavyRrFreightCar extends RailroadCar {
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
    private double netWeight;
    private double grossWeight;
    private String source;
    private HeavyFreightType heavyFreightType;
    private String shipper;
    private String securityInformation;
    private String name;
    private Color color;

    public HeavyRrFreightCar(double grossWeight, String source, HeavyFreightType heavyFreightType) {
        this.grossWeight = grossWeight;
        this.source = source;
        this.heavyFreightType = heavyFreightType;
    }

    public boolean isOverweight() {
        double difference = grossWeight - netWeight;
        return difference > 0;
    }

    public void printInfo() {
        System.out.println("Heavy Railroad Freight Car information:");
        System.out.println("ID: " + id);
        System.out.println("Source: " + source);
        System.out.println("Heavy Freight Type: " + heavyFreightType);
        System.out.println("Shipper: " + shipper);
        System.out.println("Security Info: " + securityInformation);
        System.out.println("Net Weight: " + netWeight);
        System.out.println("Gross Weight: " + grossWeight);
    }

    @Override
    public void honk() {
        System.out.println("BLOOOOPPP");
    }

    @Override
    public void siren() {
        System.out.println("DARRRRIIII");
    }

    @Override
    public String toString() {
        return "\nNet weight: " + netWeight + "\nGross weight:" + grossWeight + "\nHeavy freight car type:" + heavyFreightType;
    }
}
