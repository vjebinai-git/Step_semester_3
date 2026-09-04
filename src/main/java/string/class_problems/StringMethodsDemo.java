package string.class_problems;

public class StringMethodsDemo {

    public static void main(String[] args) {

        String city = "Chennai";

        System.out.println(city.length());
        System.out.println(city.charAt(0));
        System.out.println(city.substring(3));
        System.out.println(city.substring(1, 5));
        System.out.println(city.indexOf('n'));
        System.out.println(city.indexOf("xyz"));
        System.out.println(city.contains("hen"));
        System.out.println(city.toUpperCase());
        System.out.println(city.equalsIgnoreCase("CHENNAI"));
        System.out.println("".isEmpty());
        System.out.println(city.startsWith("Che"));
    }
}
