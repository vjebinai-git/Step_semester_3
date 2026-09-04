package string.class_problems;

import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive
    public static boolean isPalindromeRecursive(String text) {

        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        String reversedText = new String(characters);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        System.out.println();

        System.out.println("Iterative: "
                + (iterativeResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (recursiveResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (arrayResult ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }
}