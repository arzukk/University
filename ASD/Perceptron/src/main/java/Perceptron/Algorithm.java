package Perceptron;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Setter
@Getter
public class Algorithm {
    private ArrayList<Observation> testArray, trainingArray;
    private double[] weights;
    private double theta, alpha;

    public Algorithm(double alpha) {
        testArray = Service.parse("/Users/arzukilic/IdeaProjects/Perceptron/src/main/java/data/perceptron.test.data");
        trainingArray = Service.parse("/Users/arzukilic/IdeaProjects/Perceptron/src/main/java/data/perceptron.data");
        randomizeWeightsAndTheta();
        this.alpha = alpha;
    }

    //random value from within range -1 to 1
    private void randomizeWeightsAndTheta() {
        theta = (Math.random()*2)-1;

        weights = new double[Service.length];
        for (int i = 0; i < weights.length; i++)
            weights[i] = (Math.random()*2)-1;
    }

    //method calculates the weighted sum of the input values using the associated weights and bi
    // as. It then returns either 1 or 0 based on whether the weighted sum is greater than or equal to 0
    private int evaluate(Observation observation) {
        double net = theta;

        for (int i = 0; i < observation.getValues().length; i++)
            net += observation.getValues()[i] * weights[i];

        return (net >= 0? 1:0);
    }

    public void learn() {
        for (int i = 0; i < trainingArray.size(); i++) {
            int summaryError = 0;
            for (Observation observation : trainingArray) {
                int writtenDeterminant = evaluate(observation), actualDeterminant = 0;

                for (Map.Entry<String, Integer> entry : Service.determinationValues.entrySet())
                    if (entry.getKey().equals(observation.getName()))
                        actualDeterminant = entry.getValue();

                int error = actualDeterminant - writtenDeterminant;

                summaryError += error;

                for (int j = 0; j < Service.length; j++)
                    weights[j] += alpha * observation.getValues()[j] * error;

                theta += error * alpha;
            }
            if (summaryError == 0) break;
        }
    }

    //runs the trained data and runs its predictions
    public void run(boolean flag) {
        int actualDeterminant;
        double total = 0, found = 0;
        for (Observation observation : testArray) {
            actualDeterminant = evaluate(observation);

            String actualName = null;
            for (Map.Entry<String, Integer> entry : Service.determinationValues.entrySet())
                if (actualDeterminant == entry.getValue())
                    actualName = entry.getKey();

            if (flag && observation.getName().equals(actualName)) found++;
            total++;

            System.out.println((flag? observation.getName():"null") + Arrays.toString(observation.getValues()) + " -> " + actualName);
        }
        if (flag) System.out.println("Accuracy: " + total/found);
    }
}