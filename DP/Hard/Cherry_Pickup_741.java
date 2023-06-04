package DSApractice.DP.Hard;

import java.util.Arrays;

public class Cherry_Pickup_741 {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int[][] i : dp) {
            for (int[] j: i) {
                Arrays.fill(j, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, helper(grid, 0, 0, 0, m, n, dp));
    }

    private int helper(int[][] grid, int r1, int c1, int c2, int m, int n, int[][][] dp) {
        int r2 = r1 + c1 - c2;

        if (r1 == m || r2 == m || c1 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        } else if (r1 == m - 1 && c1 == m - 1) {
            return grid[r1][c1];
        } else if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][c2];
        }

        int ans = grid[r1][c1];
        if (c1 != c2) {
            ans += grid[r2][c2];
        }

        int ans1 = Math.max(helper(grid, r1, c1 + 1, c2 + 1, m, n, dp), helper(grid, r1 + 1, c1, c2 + 1, m, n, dp));
        int ans2 = Math.max(helper(grid, r1, c1 + 1, c2, m, n, dp), helper(grid, r1 + 1, c1, c2, m, n, dp));
        ans += Math.max(ans1,ans2);

        dp[r1][c1][c2] = ans;
        return ans;
    }
}