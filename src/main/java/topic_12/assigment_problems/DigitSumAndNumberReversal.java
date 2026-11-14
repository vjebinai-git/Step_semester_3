package topic_12.assigment_problems;

import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long remaining = number;
        long reversed = 0;
        long sum = 0;

        while (remaining > 0) {
            long digit = remaining % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            remaining /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
        sc.close();
    }
}

// Time complexity: O(d), where d is the number of digits; auxiliary space: O(1).
