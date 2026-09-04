package string.class_problems;

public class StringManipulationDemo {

    public static void main(String[] args) {

        // trim() removes whitespace from the beginning and end
        System.out.println(" Hello Java ".trim());

        // replace() replaces exact text
        System.out.println("I like cats".replace("cats", "dogs"));

        // split() breaks a String into an array
        String[] parts = "Ravi,25,Chennai".split(",");

        for (String part : parts) {
            System.out.println(part);
        }

        // concat() joins two Strings
        System.out.println("Hello".concat(" World"));

        // String.join() joins multiple Strings using a separator
        System.out.println(String.join("-", "2026", "07", "30"));

        // toCharArray() converts String into characters
        char[] chars = "Java".toCharArray();

        for (char c : chars) {
            System.out.print(c + " ");
        }
    }
}