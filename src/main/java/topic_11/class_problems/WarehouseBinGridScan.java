package topic_11.class_problems;

import java.util.Scanner;

public class WarehouseBinGridScan {
    // O(m*n) time and O(1) auxiliary space.
    // Strictly greater preserves the first maximum in row-major scan order.
    public static long[] warehouseSummary(int[][] grid) {
        long total = 0;
        int maxRow = -1, maxCol = -1, maximum = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int value = grid[row][col];
                total += value;

                if (value > maximum) {
                    maximum = value;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        return new long[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int[][] grid = new int[rows][cols];

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = sc.nextInt();

        long[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0]
                + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
    }
}