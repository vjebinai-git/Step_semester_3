package topic_12.assigment_problems;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0;
        int odd = 0;

        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}

// Time complexity: O(n); auxiliary space: O(1).
