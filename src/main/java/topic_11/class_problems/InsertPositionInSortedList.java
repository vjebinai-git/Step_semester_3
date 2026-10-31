package topic_11.class_problems;

import java.util.Scanner;

public class InsertPositionInSortedList {
    // Binary search: O(log n) time and O(1) auxiliary space.
    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();

        System.out.println(searchInsertPosition(nums, target));
    }
}