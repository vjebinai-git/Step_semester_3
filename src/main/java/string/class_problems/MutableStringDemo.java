package string.class_problems;

public class MutableStringDemo {

    public static void main(String[] args) {

        // StringBuilder is mutable
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World");
        System.out.println(sb);

        sb.insert(5, ",");
        System.out.println(sb);

        sb.replace(0, 5, "Hi");
        System.out.println(sb);

        sb.delete(2, 3);
        System.out.println(sb);

        // StringBuffer is also mutable and thread-safe
        StringBuffer safe = new StringBuffer("Thread-safe");

        safe.append(" text");
        System.out.println(safe);
    }
}