package DSApractice.DP.Medium;

import java.util.Arrays;

public class Unique_Paths_II_63 {

    // Memoize
    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return Memo(m - 1, n - 1, obstacleGrid, dp);
    }

    private int Memo(int m, int n, int[][] grid, int[][] dp) {
        if (m < 0 || n < 0 || grid[m][n] == 1) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = Memo(m - 1, n, grid, dp) + Memo(m, n - 1, grid, dp);
        return dp[m][n];
    }



    private int recur(int m, int n, int[][] grid) {
        // m = grid.length - 1
        // n = grid[0].length -1
        if (m < 0 || n < 0 || grid[m][n] == 1) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }

        return recur(m - 1, n, grid) + recur(m, n - 1, grid);
    }
}