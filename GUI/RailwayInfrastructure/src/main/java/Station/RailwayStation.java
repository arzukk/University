package Station;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RailwayStation {
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
    private String name;
    private List<RailwayStation> neighbors;
    private Map<RailwayStation, Double> distances;

    public RailwayStation(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.distances = new HashMap<>();
    }

        public void addNeighbor(RailwayStation neighbor, double distance) {
            neighbors.add(neighbor);
            distances.put(neighbor, distance);
        }

        public String getName() {
            return name;
        }

        public List<RailwayStation> getNeighbors() {
            return neighbors;
        }

        public double getDistanceTo(RailwayStation other) {
            return distances.getOrDefault(other, Double.POSITIVE_INFINITY);
        }

        public static List<RailwayStation> getRandomRoute(RailwayStation startStation, RailwayStation destinationStation) {
            List<RailwayStation> route = new ArrayList<>();
            RailwayStation currentStation = startStation;
            while (!currentStation.equals(destinationStation)) {
                List<RailwayStation> neighbors = currentStation.getNeighbors();
                if (neighbors.isEmpty()) {
                    break;
                }
                int randomIndex = (int) (Math.random() * neighbors.size());
                RailwayStation nextStation = neighbors.get(randomIndex);
                route.add(currentStation);
                currentStation = nextStation;
            }
            route.add(currentStation);
            return route;
        }

        public void showRouteInformation(RailwayStation startStation, RailwayStation destinationStation) {
            List<RailwayStation> route = getRandomRoute(startStation, destinationStation);
            double distanceLeft = 0.0;
            System.out.println("Current station: " + route.get(0).getName());
            for (int i = 1; i < route.size(); i++) {
                RailwayStation currentStation = route.get(i - 1);
                RailwayStation nextStation = route.get(i);
                double distance = currentStation.getDistanceTo(nextStation);
                distanceLeft += distance;
                System.out.println("Next station: " + nextStation.getName() + ", " +
                        "distance left: " + String.format("%.2f", distanceLeft) + " km");
            }
        }

    @Override
    public String toString() {
        return name;
    }
}
