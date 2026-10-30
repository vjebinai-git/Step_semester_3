package topic_10.assigment_problems;

import java.util.Scanner;

public class SecondBestScore {

    // Finds the second-highest distinct score without sorting.
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(secondHighest(scores));
        sc.close();
    }
}

/*
 * Time Complexity: O(n), because the array is visited once.
 * Auxiliary Space Complexity: O(1), because only two variables are used.
 * Sorting first takes O(n log n) time and may require additional space,
 * so the single-pass approach is more efficient.
 */
