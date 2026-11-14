package topic_12.assigment_problems;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
        }
        sc.close();
    }
}

// Time complexity: O(sqrt(n)) per number; auxiliary space: O(1).
