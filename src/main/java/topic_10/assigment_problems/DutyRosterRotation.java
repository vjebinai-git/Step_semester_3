package topic_10.assigment_problems;

import java.util.Scanner;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n;
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            rotated[newIndex] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int k = sc.nextInt();
        String[] result = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(result[i]);
        }
        System.out.println("]");
        sc.close();
    }
}

/*
 * Time Complexity: O(n), because each name is moved once.
 * Auxiliary Space Complexity: O(n), for the returned array.
 * Rotating one place at a time takes O(n * k) time. Using k % n removes
 * complete rotations, keeping the algorithm efficient even for large k.
 */
