package Mechanics;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import lombok.*;
import Interfaces.MechanicsInterface;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RailroadCar implements MechanicsInterface {
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
    private String shipper;
    private String securityInfo;
    private int numOfSeats;
    private double netWeight;
    private double grossWeight;
    private String name;
    private Date manufacturingDate;

    public RailroadCar(double netWeight, double grossWeight){
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
    }

    public RailroadCar(String name, String shipper, String securityInfo, int numOfSeats, double netWeight, double grossWeight){
        this.name = name;
        this.shipper = shipper;
        this.securityInfo = securityInfo;
        this.numOfSeats = numOfSeats;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
    }

    public void printInfo() {
        System.out.println("Railroad car information:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Shipper: " + shipper);
        System.out.println("Security Info: " + securityInfo);
        System.out.println("Number of Seats: " + numOfSeats);
        System.out.println("Net Weight: " + netWeight);
        System.out.println("Gross Weight: " + grossWeight);
    }

    public boolean isOverweight() {
        double difference = grossWeight - netWeight;
        return difference > 0;
    }

    @Override
    public void honk() {
        System.out.println("Dutdutdutudut!");
    }

    @Override
    public void siren() {
        System.out.println("Dadidadidadidai");
    }

    @Override
    public String toString() {
        return "\nNet weight: " + netWeight + "\nGross weight:" + grossWeight;
    }
}