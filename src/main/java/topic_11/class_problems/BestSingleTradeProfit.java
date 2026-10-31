package topic_11.class_problems;

import java.util.Scanner;

public class BestSingleTradeProfit {
    // One pass: O(n) time, O(1) space. Checking all day pairs is O(n^2).
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int minimumPrice = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            bestProfit = Math.max(bestProfit, prices[i] - minimumPrice);
            minimumPrice = Math.min(minimumPrice, prices[i]);
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        System.out.println(maxProfit(prices));
    }
}