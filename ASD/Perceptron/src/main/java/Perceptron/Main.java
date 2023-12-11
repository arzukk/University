/*
Mini-project: Perceptron
The training set in perceptron.data contains the Iris dataset limited to Iris-versicolor

and Iris-virginica. perceptron.test.data contains the test set. Implement the per-
ceptron and train it to classify the two species. Test with the test set and output the

accuracy.
The program should have the following capabilities:
 Loading any dataset in csv format, where the last column is the class. The number
of weights should be adjusted to the dataset. (!!)
 Picking the learning rate.
 Simple UI to manually input vectors to classify.
 Hints:
– For best results pick a small learning rage (e.g. 0.01) and repeat the learning
procedure for a larger number of iterations.
– Pick initial weights and bias randomly from the range [0, 1].

– Iris-versicolor and Iris-virginica are not linearly separable (the itera-
tion error will never be 0), but the test set can nevertheless be classified with

high accuracy.
 */
package Perceptron;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Algorithm algorithm = new Algorithm(0.1);
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isRunning = true;

    public static void main(String[] args) {
        algorithm.learn();
        algorithm.run(true);

        System.out.println("=====================================");

        setDataFromConsole();
    }

    public static void setDataFromConsole() {
        while (isRunning) {
            System.out.println("Enter attributes 'a1,a2,a3,a4,...' or 'exit': ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                isRunning = false;
                break;
            }

            String[] attrsString = line.split(",");
            double[] attributes = new double[attrsString.length];

            try {
                for (int i = 0; i < attributes.length; i++)
                    attributes[i] = Double.parseDouble(attrsString[i].trim());
            } catch (Exception exception) {
                System.out.println("Entered data is not valid!");
                System.out.println("=====================================");
                setDataFromConsole();
                break;
            }

            ArrayList<Observation> observations = new ArrayList<>();
            observations.add(new Observation(null, attributes));
            algorithm.setTestArray(observations);
            algorithm.run(false);

            System.out.println("=====================================");
        }
    }
}
