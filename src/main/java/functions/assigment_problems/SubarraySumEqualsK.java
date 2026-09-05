package functions.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();

        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int requiredSum = currentSum - k;

            if (prefixSumFrequency.containsKey(requiredSum)) {
                count += prefixSumFrequency.get(requiredSum);
            }

            prefixSumFrequency.put(
                currentSum,
                prefixSumFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println("Subarrays with Sum " + k + ": "
                + subarraySum(nums, k));
    }
}