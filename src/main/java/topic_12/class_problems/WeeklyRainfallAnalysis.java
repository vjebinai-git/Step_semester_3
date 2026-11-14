package topic_12.class_problems;

import java.util.Scanner;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rainfall = new double[7];
        double total = 0.0;
        int wettestIndex = 0;
        int dryDays = 0;

        for (int i = 0; i < rainfall.length; i++) {
            rainfall[i] = sc.nextDouble();
            total += rainfall[i];

            if (rainfall[i] > rainfall[wettestIndex] || i == 0) {
                wettestIndex = i;
            }
            if (rainfall[i] == 0.0) {
                dryDays++;
            }
        }

        System.out.print("Rainfall (mm): ");
        for (int i = 0; i < rainfall.length; i++) {
            System.out.printf("%.1f", rainfall[i]);
            if (i < rainfall.length - 1) System.out.print(" ");
        }

        System.out.printf("%n%nTotal Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", total / rainfall.length);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%n",
                wettestIndex + 1, rainfall[wettestIndex]);
        System.out.println("Total Dry Days: " + dryDays);
        sc.close();
    }
}

// Time complexity: O(7), which is O(1) for a fixed seven-day week.
// Space complexity: O(7), which is O(1) for a fixed-size array.
