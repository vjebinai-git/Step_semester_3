package topic_12.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverse(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();

        while (sc.hasNextInt()) {
            values.add(sc.nextInt());
        }

        int[] numbers = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            numbers[i] = values.get(i);
        }

        reverse(numbers);

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        sc.close();
    }
}

// Reversal takes O(n) time and O(1) auxiliary space; input storage is O(n).
