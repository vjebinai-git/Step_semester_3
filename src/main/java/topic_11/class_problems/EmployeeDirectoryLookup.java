package topic_11.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDirectoryLookup {
    // Building the map takes O(n) expected time and O(n) extra space.
    // Each department query is O(1) expected time; this suits read-heavy data.
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) lookup.put(record[0], record[1]);
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] records = new String[n][2];

        for (int i = 0; i < n; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }

        Map<String, String> lookup = buildLookup(records);
        int queries = sc.nextInt();
        while (queries-- > 0) System.out.println(getDepartment(lookup, sc.next()));
    }
}