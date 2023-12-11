package Mechanics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;
import Station.RailwayStation;
import Mechanics2.PassengerRailroadCar;
import lombok.*;
import Exception.RailroadHazardException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Locomotive<T extends RailroadCar> {
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
    private List<T> electricityGrid;
    private int electricityGridCapacity;
    private int maxRailroadCar;
    private float loadWeight;
    private String source;
    private double speed;
    private String name;
    private RailwayStation homeRs;
    private RailwayStation destinationRs;
    private float weight = 0;

    public Locomotive(int electricityGridCapacity, float loadWeight, String source, double speed, int maxRailroadCar, String name, RailwayStation homeRs, RailwayStation destinationRs) throws Exception {
        this.electricityGridCapacity = electricityGridCapacity;
        this.loadWeight = loadWeight;
        this.source = source;
        this.speed = speed;
        this.electricityGrid = new ArrayList<>();
        this.name = name;
        this.homeRs = homeRs;
        this.destinationRs = destinationRs;
        if(maxRailroadCar<electricityGridCapacity){
            throw new Exception("Electricity grid capacity can't exceed locomotive capacity");
        }
    }

    public int getTotalNumOfPeople() {
        int totalNumOfPeople = 0;
        for (RailroadCar car : electricityGrid) {
            if (car instanceof PassengerRailroadCar) {
                totalNumOfPeople += ((PassengerRailroadCar) car).getNumOfPeople();
            }
        }
        return totalNumOfPeople;
    }

    public void updateSpeed() throws RailroadHazardException {
        Trainset trainset = new Trainset();
        Random rand = new Random();
        double change = speed * 0.03;
        if (rand.nextBoolean()) {
            speed += change;
        } else {
            speed -= change;
        }
        if (speed > 200) {
            throw new RailroadHazardException("The speed cant exceed 200", "Trainset id %d:", trainset.getId());
        }
    }

    public float getWeight() {
        float weight = 0;
        for (T car : electricityGrid) {
            weight += car.getGrossWeight();
        }
        return weight;
    }

    public void addElectricityGrid(T eg) throws Exception {
        if (electricityGrid.size() + 1 <= electricityGridCapacity) {
            if (getWeight() + eg.getGrossWeight() <= loadWeight) {
                electricityGrid.add(eg);
            } else {
                throw new Exception("Load weight exceeded");
            }
        } else {
            throw new Exception("Electricity grid is full");
        }
    }

    public void removeElectricityGrid(T eg) {
        electricityGrid.remove(eg);
    }

    public int getNumOfVehicles() {
        return electricityGrid.size();
    }

//    @Override
//    public String toString() {
//        return "\nElectricity grid capacity: " + electricityGridCapacity + "\nLoad weight:" +  loadWeight + "\nSource:" + source + "\nSpeed:" + speed + "\nMax railroad car" +
//                maxRailroadCar + "\nName: " + name + "\nHome station:" + homeRs + "\nDestination station" + destinationRs;
//    }
}
