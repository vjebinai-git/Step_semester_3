package topic_11.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class HeightLineUp {
    // Bubble sort: O(n^2) worst-case time, O(1) auxiliary space.
    // Prints each left-to-right sweep and stops early after a sweep with no swaps.
    public static void lineUp(int[] heights) {
        for (int pass = 1; pass < heights.length; pass++) {
            boolean swapped = false;

            for (int j = 0; j < heights.length - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) heights[i] = sc.nextInt();
        lineUp(heights);
    }
}