package topic_10.assigment_problems;

import java.util.Scanner;

public class ExamScoreBandCounter {

    // Returns the first index whose value is greater than or equal to target.
    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Returns the first index whose value is strictly greater than target.
    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int first = lowerBound(scores, low);
        int afterLast = upperBound(scores, high);
        return afterLast - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}

/*
 * Linear scan: O(n) time and O(1) auxiliary space.
 * Binary-search solution: O(log n) time and O(1) auxiliary space.
 * lowerBound finds the first value >= low, while upperBound finds the
 * first value > high. This includes every duplicate at both boundaries.
 */
