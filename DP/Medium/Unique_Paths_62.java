package DSApractice.DP.Medium;

import java.util.Arrays;

public class Unique_Paths_62 {
    // Tabulation
    public int uniquePathsTabulation(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        dp[0][0] = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    // memoize
    public int uniquePathsMemoize(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        dp[m][n] = helper(m - 1, n - 1, dp);
        return dp[m][n];
    }

    private int helper(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = helper(m - 1, n, dp) + helper(m, n - 1, dp);
        return dp[m][n];
    }
}