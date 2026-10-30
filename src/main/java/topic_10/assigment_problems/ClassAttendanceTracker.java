package topic_10.assigment_problems;

import java.util.Scanner;

public class ClassAttendanceTracker {

    public static int[] attendanceSummary(int[] days) {
        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentDays++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentDays, longestStreak};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] result = attendanceSummary(days);
        System.out.printf("Present: %d, Longest streak: %d%n",
                result[0], result[1]);
        sc.close();
    }
}

/*
 * Time Complexity: O(n), because each day's attendance is checked once.
 * Auxiliary Space Complexity: O(1), excluding the two-value result array.
 * Both the present-day count and longest streak are calculated in one pass.
 */
