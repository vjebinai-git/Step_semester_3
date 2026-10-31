package topic_11.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderTraversal {
    // O(m*n) time; O(m*n) space for the returned list.
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0 || grid[0].length == 0) return result;

        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) result.add(grid[top][col]);
            top++;

            for (int row = top; row <= bottom; row++) result.add(grid[row][right]);
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) result.add(grid[bottom][col]);
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) result.add(grid[row][left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int[][] grid = new int[rows][cols];

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = sc.nextInt();

        System.out.println(spiralOrder(grid));
    }
}