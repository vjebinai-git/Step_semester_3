package topic_10.class_problems;

import java.util.Scanner;

public class WordReverserPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();

            System.out.println(reversed + (word.equalsIgnoreCase(reversed)
                    ? " - palindrome" : " - not a palindrome"));
        }
    }
}