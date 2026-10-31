package topic_11.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class DiceThrowTally {
    // Counting sort for die results: O(n + 6) time and O(n + 6) extra space.
    // No comparisons between individual throws are performed.
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            if (roll < 1 || roll > 6) {
                throw new IllegalArgumentException("Each die result must be between 1 and 6.");
            }
            count[roll]++;
        }

        System.out.print("Counts:");
        for (int value = 1; value <= 6; value++) {
            System.out.print(" " + value + ":" + count[value]);
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int occurrence = 0; occurrence < count[value]; occurrence++) {
                sorted[index++] = value;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }

        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}