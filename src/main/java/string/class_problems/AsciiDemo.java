package string.class_problems;

public class AsciiDemo {

    public static void main(String[] args) {

        // Character to ASCII
        char letter = 'A';
        System.out.println((int) letter);

        // ASCII to character
        char back = (char) 97;
        System.out.println(back);

        // Uppercase to lowercase using ASCII difference
        char upper = 'M';
        char lower = (char) (upper + 32);
        System.out.println(lower);

        // Printing the whole alphabet using ASCII values
        for (int i = 65; i <= 90; i++) {
            System.out.print((char) i);
        }

        System.out.println();

        // Built-in Character methods
        System.out.println(Character.isDigit('7'));
        System.out.println(Character.isLetter('Z'));
        System.out.println(Character.toUpperCase('m'));
    }
}