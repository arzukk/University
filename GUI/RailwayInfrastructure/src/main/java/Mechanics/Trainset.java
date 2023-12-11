package Mechanics;
import Station.RailwayStation;
import lombok.*;
import Exception.TrainsetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Exception.RailroadHazardException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Trainset {
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
    private static final int STATION_WAIT_TIME = 2000; // in milliseconds
    private static final int DESTINATION_WAIT_TIME = 30000; // in milliseconds
    private Random random;
    private long startTime;
    private Lock lock = new ReentrantLock();
    private RailwayStation startStation;
    private RailwayStation destinationStation;
    private double currentPosition = 0.0;
    private Locomotive locomotive;
    private int maxRailroadCarsNumber;
    private Double maxRailroadCarsWeight;
    private Map<RailwayStation, List<RailwayStation>> railwayRoute;

    public Trainset(int maxRailroadCarsNumber, double maxRailroadCarsWeight) {
        this.maxRailroadCarsNumber = maxRailroadCarsNumber;
        this.maxRailroadCarsWeight = maxRailroadCarsWeight;
    }

    public Trainset(Locomotive locomotive){
        this.locomotive = locomotive;
    }

    public Trainset(Locomotive locomotive, int maxRailroadCarsNumber, double maxRailroadCarsWeight) throws TrainsetException {
        this.locomotive = locomotive;
        this.maxRailroadCarsWeight = maxRailroadCarsWeight;
        this.maxRailroadCarsNumber = maxRailroadCarsNumber;
        this.startStation = locomotive.getHomeRs();
        this.destinationStation = locomotive.getDestinationRs();
        if (locomotive.getWeight() > maxRailroadCarsWeight || locomotive.getElectricityGrid().size() +locomotive.getMaxRailroadCar() > maxRailroadCarsNumber) {
            throw new TrainsetException("Locomotive weight or number of vehicles exceeds maximum limit.");
        }
    }

    public List<RailwayStation> getRoute(){
        return RailwayStation.getRandomRoute(startStation, destinationStation);
    }

    public double getRouteLength() {
        double wholeDistance = 0.0;

        List<RailwayStation> route = getRoute();
        for (int i = 0; i < route.size() - 1; i++) {
            wholeDistance += route.get(i).getDistanceTo(route.get(i + 1));
        }
        return wholeDistance;
    }

    public static void getInfo(Trainset trainset) {
        System.out.println("Destination station is: " + trainset.getDestinationStation());
        System.out.println("Current position is: " + trainset.getCurrentPosition());
        System.out.println("Start station is: " + trainset.getStartStation());
        System.out.println("Trainset id is: " + trainset.getId());
        System.out.println("Locomotive is: " + trainset.getLocomotive());
        System.out.println("Max railroad cars number is: " + trainset.getMaxRailroadCarsNumber());
        System.out.println("Max railroad cars weight is: " + trainset.getMaxRailroadCarsWeight());
    }

    public double getTimeElapsed() {
        return (System.currentTimeMillis() - startTime) / 1000.0;
    }

    public void run() throws RailroadHazardException {
        startTime = System.currentTimeMillis();
        double wholeDistance = 0.0;

        List<RailwayStation> route = getRoute();
        for (int i = 0; i < route.size() - 1; i++) {
            wholeDistance += route.get(i).getDistanceTo(route.get(i + 1));
        }

        while (true) {
            try {
                System.out.printf("Trainset : route from %s to %s is %s\n",
                        startStation.getName(), destinationStation.getName(), getRoute());

                for (int i = 0; i < getRoute().size() - 1; i++) {
                    getLocomotive().updateSpeed();
                    RailwayStation curr = getRoute().get(i);
                    RailwayStation next = getRoute().get(i + 1);

                    double distanceToNextStation = curr.getDistanceTo(next);
                    double distanceTravelled = getLocomotive().getSpeed() * getTimeElapsed();
                    double distanceLeft = Math.max(wholeDistance - distanceTravelled, 0);

                    if (distanceTravelled >= wholeDistance) {
                        distanceLeft = 0;
                    }

                    double percentageFinished = Math.min((distanceTravelled / wholeDistance) * 100, 100);
                    double percentageLeft = 100 - percentageFinished;

                    this.lock.lock();
                    System.out.printf("Trainset %d: acquired lock for %s\n", id, curr);

                    try {
                        Thread.sleep(STATION_WAIT_TIME);
                        System.out.printf("Waited for:%d\nTrainset %d: moving from %s to %s\nDistance left:%s\n", STATION_WAIT_TIME, id, curr, next, distanceLeft);
                        System.out.println("The percentage of the distance completed:" + percentageFinished);
                        System.out.println("current position:" + distanceTravelled);
                        System.out.println("\nSpeed:" + getLocomotive().getSpeed());
                        this.lock.unlock();
                        System.out.printf("Trainset %d: released lock for %s\n", id, curr);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    System.out.printf("Trainset %d: reached destination %s, waiting for %dms\n",
                            id, destinationStation, DESTINATION_WAIT_TIME);
                    System.out.println("\nSpeed:" + getLocomotive().getSpeed());
                    Thread.sleep(DESTINATION_WAIT_TIME);
                    List<RailwayStation> newRoute = new ArrayList<>(getRoute());
                    Collections.reverse(newRoute);

                    RailwayStation temp = startStation;
                    startStation = destinationStation;
                    destinationStation = temp;

                    startTime = System.currentTimeMillis();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: IndexOutOfBoundsException caught - " + e.getMessage());
            }
        }

    }

    public void run2() throws RailroadHazardException {
        startTime = System.currentTimeMillis();
        double wholeDistance = 0.0;

        List<RailwayStation> route = getRoute();
        for (int i = 0; i < route.size() - 1; i++) {
            wholeDistance += route.get(i).getDistanceTo(route.get(i + 1));
        }

        while (true) {
            try {
                System.out.printf("Trainset : route from %s to %s is %s\n",
                        startStation.getName(), destinationStation.getName(), getRoute());

                for (int i = 0; i < getRoute().size() - 1; i++) {
                        getLocomotive().updateSpeed();
                        RailwayStation curr = getRoute().get(i);
                        RailwayStation next = getRoute().get(i + 1);

                        double distanceToNextStation = curr.getDistanceTo(next);
                        double distanceTravelled = getLocomotive().getSpeed() * getTimeElapsed();
                        double distanceLeft = Math.max(wholeDistance - distanceTravelled, 0);

                        if (distanceTravelled >= wholeDistance) {
                            distanceLeft = 0;
                        }

                    double percentageFinished = 0;
                    if (distanceToNextStation > 0) {
                        double totalDistanceToNextStation = 0;
                        if (i > 0) {
                            List<RailwayStation> previousStations = getRoute().subList(0, i);
                            for (RailwayStation station : previousStations) {
                                totalDistanceToNextStation += station.getDistanceTo(getRoute().get(getRoute().indexOf(station) + 1));
                            }
                        }
                        percentageFinished = Math.min((distanceTravelled - totalDistanceToNextStation) / distanceToNextStation * 100, 100);
                    }

                this.lock.lock();
                    System.out.printf("Trainset %d: acquired lock for %s\n", id, curr);

                    try {
                        Thread.sleep(STATION_WAIT_TIME);
                        System.out.printf("Waited for:%d\nTrainset %d: moving from %s to %s\nDistance left:%s\n", STATION_WAIT_TIME, id, curr, next, distanceLeft);
                        System.out.println("current position:" + distanceTravelled);
                        System.out.println("\nSpeed:" + getLocomotive().getSpeed());
                        this.lock.unlock();
                        System.out.printf("Trainset %d: released lock for %s\n", id, curr);
                        System.out.println("The percentage of the distance completed between " + curr.getName() + " and " + next.getName() + " is " + percentageFinished + "%");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    System.out.printf("Trainset %d: reached destination %s, waiting for %dms\n",
                            id, destinationStation, DESTINATION_WAIT_TIME);
                    System.out.println("\nSpeed:" + getLocomotive().getSpeed());
                    Thread.sleep(DESTINATION_WAIT_TIME);
                    List<RailwayStation> newRoute = new ArrayList<>(getRoute());
                    Collections.reverse(newRoute);

                    RailwayStation temp = startStation;
                    startStation = destinationStation;
                    destinationStation = temp;

                    startTime = System.currentTimeMillis();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: IndexOutOfBoundsException caught - " + e.getMessage());
            }
        }

    }
}
