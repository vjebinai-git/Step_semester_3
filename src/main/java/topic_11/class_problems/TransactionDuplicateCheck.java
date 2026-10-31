package topic_11.class_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TransactionDuplicateCheck {
    // HashSet: O(n) expected time and O(n) additional space.
    // Lower-memory alternative: sort then compare adjacent IDs (O(n log n)
    // time); sorting a copy preserves the input but requires O(n) space.
    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();

        for (String id : transactionIds) {
            if (!seen.add(id)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ids = new String[n];

        for (int i = 0; i < n; i++) ids[i] = sc.next();
        System.out.println(hasDuplicate(ids));
    }
}