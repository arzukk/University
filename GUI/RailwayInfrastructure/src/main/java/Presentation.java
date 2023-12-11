import Mechanics.Locomotive;
import Mechanics.RailroadCar;
import Mechanics.Trainset;
import Mechanics2.*;
import Station.RailroadPostOffice;
import Station.RailwayStation;
import java.util.List;
import static Enums.BasicFreightType.LIQUID_RR_CAR;
import static Enums.HeavyFreightType.TOXIC_RR_CAR;

public class Presentation {
    public static void main(String[] args) throws Exception {
        BasicRrFreightCar basicRrFreightCar1 = new BasicRrFreightCar(50.0, "metal", LIQUID_RR_CAR);
        HeavyRrFreightCar heavyRrFreightCar1 = new HeavyRrFreightCar(70.5, "metal", TOXIC_RR_CAR);
        MailCar mailCar1 = new MailCar(20.0, "metal");
        PassengerRailroadCar passengerRailroadCar1 = new PassengerRailroadCar(120.0, 2);
        RrRestaurantCar rrRestaurantCar1 = new RrRestaurantCar(120.0, "metal");
        RailwayStation stationA = new RailwayStation("Station A");
        RailwayStation stationB = new RailwayStation("Station B");
        RailwayStation stationC = new RailwayStation("Station C");
        RailwayStation stationD = new RailwayStation("Station D");
        RailwayStation stationE = new RailwayStation("Station E");
        RailwayStation stationF = new RailwayStation("Station F");
        RailwayStation stationG = new RailwayStation("Station G");
        RailwayStation stationH = new RailwayStation("Station H");
        //station neighbor
        stationA.addNeighbor(stationB, 100.0);
        stationA.addNeighbor(stationC, 150.0);
        stationB.addNeighbor(stationC, 50.0);
        stationC.addNeighbor(stationD, 200.0);
        stationD.addNeighbor(stationE, 200.0);
        stationE.addNeighbor(stationF, 250.0);
        stationF.addNeighbor(stationG, 350.0);
        stationG.addNeighbor(stationH, 500.0);
        Baggage baggage = new Baggage(200.0, "metal");

        //Locomotive creation
        Locomotive locomotive1 = new Locomotive(30, 500F, "metal", 100.0,32, "locomotive1", stationA, stationH);

        //Trainset creation and its attachment to locomotive
        Trainset trainset1 = new Trainset(locomotive1, 20, 300.0);

        //Attaching railroad car to locomotive
        trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar1);
        trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar1);

        //The display of locomotive weight
        System.out.println("\nThe total weight of locomotive");
        System.out.println(trainset1.getLocomotive().getWeight());

        //The total number of people based in a locomotive
        System.out.println("The total number of people based in locomotive:");
        System.out.println(trainset1.getLocomotive().getTotalNumOfPeople());
        System.out.println();

        //Railroad car detachment from locomotive
        trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar1);

        //generate random route
        List<RailwayStation> route = stationA.getRandomRoute(stationA, stationH);
        //New route generated

        for (RailwayStation station : route) {
            System.out.println(station.getName());
        }
        //Route information
        System.out.println("\nRoute information:");
        stationA.showRouteInformation(stationA, stationH);

        //station neighbors
        System.out.println("\nStation A neighbors:");
        System.out.println(stationA.getNeighbors());

        //Station distance
        System.out.println("\nThe distance between stationA and stationC:");
        System.out.println(stationA.getDistanceTo(stationC));

        //route length
        System.out.println("\nRoute length:");
        System.out.println(trainset1.getRouteLength());

        //Route generation in trainset class
        System.out.println("\nThe second route generation:");
        System.out.println(trainset1.getRoute());

        //number of vehicles in electricity grid
        System.out.println("\nNumber of vehicles in electricity grid in locomotive 1");
        System.out.println(trainset1.getLocomotive().getNumOfVehicles());
        System.out.println();

        // Railroad car info
        RailroadCar railroadCar = new RailroadCar("railRoadCar", "HSBC", "EXPLOSIVE", 20, 200.0, 300.0);
        railroadCar.printInfo();
        System.out.println();

        // Railroad car overweight check
        System.out.println("Railroad car is overweight?");
        System.out.println(railroadCar.isOverweight());

        //Railroad Post office open and close operations
        RailroadPostOffice railroadPostOffice = new RailroadPostOffice("railroadPostOffice");
        System.out.println("\nAfter open() method:\n");
        System.out.println("Is post office opened?");
        railroadPostOffice.open();
        System.out.println("\n");
        System.out.println("After close() method:\n");
        System.out.println("Is post office closed?");
        railroadPostOffice.close();
    }
}
