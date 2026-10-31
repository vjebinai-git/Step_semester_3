package topic_11.class_problems;

import java.util.Scanner;

public class LibraryCatalogLookup {
    // Binary search: O(log n) time, O(1) auxiliary space.
    // Ideal when reads greatly outnumber updates: keep the catalog sorted,
    // then each query is fast; occasional updates can pay the insertion cost.
    public static String findBook(String[][] catalog, String targetIsbn) {
        int left = 0, right = catalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = catalog[mid][0].compareTo(targetIsbn);

            if (comparison == 0) return catalog[mid][1];
            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] catalog = new String[n][2];

        for (int i = 0; i < n; i++) {
            catalog[i][0] = sc.nextLine().trim();
            catalog[i][1] = sc.nextLine();
        }

        int queries = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < queries; i++) {
            System.out.println(findBook(catalog, sc.nextLine().trim()));
        }
    }
}