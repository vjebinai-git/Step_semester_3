package string.class_problems;

public class StringOperationsandPerformance {

    public static void main(String[] args) {

        // String Pool
        String a = "Java";
        String b = "Java";

        System.out.println("a == b: " + (a == b));

        // Creating a separate String object
        String c = new String("Java");

        System.out.println("a == c: " + (a == c));
        System.out.println("a.equals(c): " + a.equals(c));

        // String is immutable
        String greeting = "Hello";

        greeting = greeting + " World";

        System.out.println("Greeting: " + greeting);

        // String concatenation inside a loop
        String result = "";

        for (int i = 0; i < 5; i++) {
            result += "x";
        }

        System.out.println("String result: " + result);

        // StringBuilder for repeated modification
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            builder.append("x");
        }

        System.out.println("StringBuilder result: " + builder);
    }
}