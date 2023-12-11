/*
Mini-project: k-means
Implement the k-means algorithm. Cluster the iris dataset in in iris.data (ignore the
decision attribute).
Additional requirements:
 Allow the user to pick k.
 After every iteration: print the sum of distances from each point from its centroid.
This value should decrease with every iteration. Note: print the total for all points,
not each cluster separately. Example:
Iteration 1: 126.38
Iteration 2: 86.34
Iteration 3: 49.91
...
 At the end: print the members of each cluster.
 Optional: print measures of cluster homogeneity, eg. percentage of each iris class per
cluster, or entropy.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KMeans {
    private static final double EPSILON = 1e-6;
    private static final int MAX_ITERATIONS = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        List<Iris> dataset = loadIrisDataset();
        List<Cluster> clusters = runKMeans(dataset, k);

        System.out.println("Final clusters:");
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ":");
            System.out.println(clusters.get(i).getMembers());
            System.out.println("=====================================");
        }
    }

    private static List<Iris> loadIrisDataset() {
        List<Iris> dataset = new ArrayList<>();

        try {
            File file = new File("/Users/arzukilic/IdeaProjects/K-means/src/main/java/iris.data");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                if (values.length == 5) {
                    double[] attributes = new double[4];
                    for (int i = 0; i < 4; i++) {
                        attributes[i] = Double.parseDouble(values[i]);
                    }

                    String species = values[4];

                    dataset.add(new Iris(attributes, species));
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private static List<Cluster> runKMeans(List<Iris> dataset, int k) {
        Random random = new Random();
        List<Iris> centroids = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            int index = random.nextInt(dataset.size());
            centroids.add(dataset.get(index));
        }

        double previousDistanceSum = Double.MAX_VALUE;
        for (int iteration = 1; iteration <= MAX_ITERATIONS; iteration++) {
            List<Cluster> clusters = assignClusters(dataset, centroids);

            updateCentroids(clusters);

            double distanceSum = calculateDistanceSum(clusters);

            System.out.println("Iteration " + iteration + ": " + distanceSum);

            if (previousDistanceSum - distanceSum == 0) {
                break;
            }
            previousDistanceSum = distanceSum;
        }

        return assignClusters(dataset, centroids);
    }

    private static List<Cluster> assignClusters(List<Iris> dataset, List<Iris> centroids) {
        List<Cluster> clusters = new ArrayList<>(centroids.size());
        for (int i = 0; i < centroids.size(); i++) {
            clusters.add(new Cluster());
        }

        for (Iris dataPoint : dataset) {
            double minDistance = Double.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < centroids.size(); i++) {
                double distance = calculateDistance(dataPoint, centroids.get(i));
                if (distance < minDistance) {
                    minDistance = distance;
                    minIndex = i;
                }
            }
            clusters.get(minIndex).addMember(dataPoint);
        }

        return clusters;
    }

    private static double calculateDistance(Iris point1, Iris point2) {
        double sum = 0;
        for (int i = 0; i < point1.getAttributes().length; i++) {
            sum += Math.pow(point1.getAttributes()[i] - point2.getAttributes()[i], 2);
        }
        return Math.sqrt(sum);
    }

    private static void updateCentroids(List<Cluster> clusters) {
        for (Cluster cluster : clusters) {
            double[] centroid = new double[cluster.getMembers().get(0).getAttributes().length];
            Arrays.fill(centroid, 0);

            for (Iris member : cluster.getMembers()) {
                for (int i = 0; i < member.getAttributes().length; i++) {
                    centroid[i] += member.getAttributes()[i];
                }
            }

            for (int i = 0; i < centroid.length; i++) {
                centroid[i] /= cluster.getMembers().size();
            }

            cluster.setCentroid(new Iris(centroid, null)); // Set species as null for centroid
        }
    }


    private static double calculateDistanceSum(List<Cluster> clusters) {
        double sum = 0;
        for (Cluster cluster : clusters) {
            for (Iris member : cluster.getMembers()) {
                sum += calculateDistance(member, cluster.getCentroid());
            }
        }
        return sum;
    }

    static class Iris {
        private double[] attributes;
        private String species;

        public Iris(double[] attributes, String species) {
            this.attributes = attributes;
            this.species = species;
        }

        public double[] getAttributes() {
            return attributes;
        }

        public String getSpecies() {
            return species;
        }

        @Override
        public String toString() {
            return "Iris{" +
                    "attributes=" + Arrays.toString(attributes) +
                    ", species='" + species + '\'' +
                    "}\n";
        }
    }

    static class Cluster {
        private List<Iris> members;
        private Iris centroid;

        public Cluster() {
            members = new ArrayList<>();
        }

        public List<Iris> getMembers() {
            return members;
        }

        public void addMember(Iris member) {
            members.add(member);
        }

        public Iris getCentroid() {
            return centroid;
        }

        public void setCentroid(Iris centroid) {
            this.centroid = centroid;
        }
    }
}
