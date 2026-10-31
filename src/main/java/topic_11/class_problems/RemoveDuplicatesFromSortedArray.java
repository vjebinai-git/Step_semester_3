package topic_11.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    // Two pointers: O(n) time and O(1) additional space (in-place).
    // Only the first returned-length positions are meaningful after the call.
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueCount = 1;
        for (int current = 1; current < nums.length; current++) {
            if (nums[current] != nums[uniqueCount - 1]) {
                nums[uniqueCount] = nums[current];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = "
                + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}