import java.util.Random;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 29.9) return "Overweight";
        else return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-6d | %-10.2f | %-11.1f | %-5.2f | %s%n",
                    (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random rand = new Random();

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + rand.nextDouble() * 0.4; // 1.50 - 1.90 m
            weights[i] = 50 + rand.nextDouble() * 50;    // 50 - 100 kg
        }

        printWellnessReport(heights, weights);
    }
}