package DSApractice.DP.Medium;

import java.util.Arrays;

public class Minimum_Path_Sum_64 {

    // Space optimize
    public int minPathSumSpace(int[][] grid) {
        int m = grid.length;    // row
        int n = grid[0].length; // col

        int[] prev = new int[n]; // previous column
        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];    // current column

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                } else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

                    if (i > 0) up = prev[j];
                    if (j > 0) left = curr[j - 1];

                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;    // curr becomes prev for next
        }

        return prev[n - 1];
    }

    // Tabulation
    public int minPathSumTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];

                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // Memoize
    public int minPathSumMemioze(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return Memioze(m - 1, n - 1, grid, dp);
    }

    private int Memioze(int m, int n, int[][] grid, int[][] dp) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if (m == 0 && n == 0) {
            return grid[0][0];
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = grid[m][n] + Math.min(Memioze(m - 1, n, grid, dp), Memioze(m, n - 1, grid, dp));
        return dp[m][n];
    }


    // Recursive
    public int minPathSumRecur(int[][] grid) {
        return recursive(grid.length - 1, grid[0].length - 1, grid);
    }

    private int recursive(int m, int n, int[][] grid) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if (m == 0 && n == 0) {
            return grid[0][0];
        }

        return grid[m][n] + Math.min(recursive(m - 1, n, grid), recursive(m, n - 1, grid));
    }
}