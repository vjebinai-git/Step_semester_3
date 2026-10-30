package topic_10.assigment_problems;

import java.util.Scanner;

public class BusiestBusRow {

    // Returns {rowIndex, rowTotal}. Ties are resolved in favor of the
    // smaller row index by updating only when a strictly larger total appears.
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int rowTotal = 0;

            for (int j = 0; j < grid[i].length; j++) {
                rowTotal += grid[i][j];
            }

            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestRow = i;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] grid = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = busiestRow(grid);
        System.out.printf("Row %d, Total %d%n", result[0], result[1]);
        sc.close();
    }
}

/*
 * Time Complexity: O(r * c), because every grid cell is visited once.
 * Auxiliary Space Complexity: O(1), excluding the two-value result array.
 */
