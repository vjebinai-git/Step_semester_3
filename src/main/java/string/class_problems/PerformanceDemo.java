package string.class_problems;

public class PerformanceDemo {

    public static void main(String[] args) {

        int n = 50_000;

        // Slow: creates a new String on every iteration
        String result = "";

        long t1 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            result += "x";
        }

        long time1 = (System.nanoTime() - t1) / 1_000_000;

        // Fast: reuses one StringBuilder
        StringBuilder sb = new StringBuilder();

        long t2 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            sb.append("x");
        }

        long time2 = (System.nanoTime() - t2) / 1_000_000;

        System.out.println("String += : " + time1 + " ms");
        System.out.println("StringBuilder : " + time2 + " ms");
    }
}