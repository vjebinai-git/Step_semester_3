package topic_12.assigment_problems;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculation {
    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            if (number < 0) {
                System.out.println("Invalid input");
            } else {
                System.out.println(factorial(number));
            }
        }
        sc.close();
    }
}

// Time complexity: O(n) multiplications; result storage grows with n.
