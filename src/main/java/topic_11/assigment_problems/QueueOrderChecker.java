package topic_11.assigment_problems;

import java.util.Scanner;

public class QueueOrderChecker {
    // O(n) time and O(1) auxiliary space.
    // Returns the index of the first token smaller than its predecessor.
    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tokens = new int[n];

        for (int i = 0; i < n; i++) tokens[i] = sc.nextInt();
        System.out.println(firstBreak(tokens));
    }
}