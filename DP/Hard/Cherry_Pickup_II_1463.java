package DSApractice.DP.Hard;

import java.util.Arrays;

public class Cherry_Pickup_II_1463 {

    // Tabulation
    public int cherryPickupTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        // base case
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;

                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }

                            if (j1 + dj1 >= 0 && j1 + dj1 < n && j2 + dj2 >= 0 && j2 +dj2 < n) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                value += Integer.MIN_VALUE;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][n - 1];
    }

    // Memoize
    public int cherryPickupMemoize(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        return memoize(0, 0, n - 1, m, n, grid, dp);
    }

    private int memoize(int i, int j1, int j2, int m, int n, int[][] grid, int[][][] dp) {

        // base case - out of bound
        if (j1 < 0 || j2 < 0 || j1 >= n || j2 >= n) {
            return Integer.MIN_VALUE;
        }
        // base case - last row
        if (i == m - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        // explore all paths
        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                maxi = Math.max(maxi, value + memoize(i + 1, j1 + dj1, j2 + dj2, m, n, grid, dp));
            }
        }

        dp[i][j1][j2] = maxi;
        return maxi;
    }

    // Recursive
    public int cherryPickupRec(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return recursive(0, 0, n - 1, m, n, grid);
    }

    private int recursive(int i, int j1, int j2, int m, int n, int[][] grid) {

        // base case - out of bound
        if (j1 < 0 || j2 < 0 || j1 >= n || j2 >= n) {
            return Integer.MIN_VALUE;
        }
        // base case - last row
        if (i == m - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        // explore all paths
        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                maxi = Math.max(maxi, value + recursive(i + 1, j1 + dj1, j2 + dj2, m, n, grid));
            }
        }

        return maxi;
    }
}