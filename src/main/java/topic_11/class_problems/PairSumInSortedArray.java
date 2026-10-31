package topic_11.class_problems;

import java.util.Scanner;

public class PairSumInSortedArray {
    // Two pointers: O(n) time and O(1) auxiliary space.
    // An unsorted brute-force search takes O(n^2) time.
    // Returns null when no pair exists; otherwise returns the pair of values.
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum == target) return new int[]{nums[left], nums[right]};
            if (sum < target) left++;
            else right--;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();

        int[] pair = pairSumSorted(nums, target);
        if (pair == null) System.out.println("Not Found");
        else System.out.println("(" + pair[0] + ", " + pair[1] + ")");
    }
}