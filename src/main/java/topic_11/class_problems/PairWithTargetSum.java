package topic_11.class_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairWithTargetSum {
    // HashSet approach: O(n) expected time, O(n) extra space.
    // Alternatives: nested loops use O(n^2) time/O(1) space; sorting and
    // two pointers use O(n log n) time and O(1) extra space if sorting in-place.
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int value : nums) {
            if (seen.contains(target - value)) return true;
            seen.add(value);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();

        System.out.println(hasPairWithSum(nums, target));
    }
}