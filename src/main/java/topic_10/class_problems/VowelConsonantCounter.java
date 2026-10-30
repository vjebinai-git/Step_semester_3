package topic_10.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        int vowels = 0;
        int consonants = 0;

        for (char ch : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}