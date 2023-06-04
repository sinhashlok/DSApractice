package DSApractice.DP.Medium;

import java.util.Arrays;

public class Maximum_Path_Sum_in_the_matrix_CS {
    // Space Optimized
    // we use the given array only to store max sums on each row
    public static int getMaxPathSumOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ld = Integer.MIN_VALUE;
                int c = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;

                if (j != 0) {
                    ld = matrix[i - 1][j - 1];
                }
                if (j != n - 1) {
                    rd = matrix[i - 1][j + 1];
                }
                c = matrix[i - 1][j];

                matrix[i][j] += Math.max(c, Math.max(ld, rd));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, matrix[m - 1][j]);
        }

        return max;
    }


    // Memoize
    public static int getMaxPathSumMemoize(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MIN_VALUE);
        }
        // go through the entire first row
        for (int j = 0; j < n; j++) {
            max = Math.max(max, memoize(matrix, m, n, 0, j, dp));
        }

        return max;
    }

    private static int memoize(int[][] matrix, int m, int n, int i, int j, int[][] dp) {
        // check if on last row
        if (i == m) {
            return 0;
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
        // Left?
        if (j != 0) {
            l = memoize(matrix, m, n, i + 1, j - 1, dp);
        }
        // down
        d = memoize(matrix, m, n, i + 1, j, dp);
        // Right?
        if (j != n - 1) {
            r = memoize(matrix, m, n, i + 1, j + 1, dp);
        }

        dp[i][j] = matrix[i][j] + Math.max(l, Math.max(d, r));
        return dp[i][j];
    }


    // Recursive
    public static int getMaxPathSumRecursive(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        // go through the entire first row
        for (int j = 0; j < n; j++) {
            max = Math.max(max, recursive(matrix, m, n, 0, j));
        }

        return max;
    }

    private static int recursive(int[][] matrix, int m, int n, int i, int j) {
        // check if on last row
        if (i == m) {
            return 0;
        }

        int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
        // Left?
        if (j != 0) {
            l = recursive(matrix, m, n, i + 1, j - 1);
        }
        // down
        d = recursive(matrix, m, n, i + 1, j);
        // Right?
        if (j != n - 1) {
            r = recursive(matrix, m, n, i + 1, j + 1);
        }

        return matrix[i][j] + Math.max(l, Math.max(d, r));
    }
}