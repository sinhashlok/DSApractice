package DSApractice.DP.Easy;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        System.out.println(frogJump(arr.length, arr));
    }

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        return memoize(n - 1, heights, dp);
    }

    // TLE
    private static int recursive(int n, int[] heights) {
        if (n == 0) {
            return 0;
        }

        int l = 0, r = 0;
        l = recursive(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        if (n > 1) {
            r = recursive(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return Math.min(l, r);
    }

    private static int memoize(int n, int[] heights, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        l = memoize(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        if (n > 1) {
            r = memoize(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }

        dp[n] = Math.min(l, r);
        return dp[n];
    }

    public static int Tabulation(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int l = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int r = Integer.MAX_VALUE;
            if (i > 1) {
                r = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(l, r);
        }

        return dp[n - 1];
    }

    public static int optimized(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int l = prev + Math.abs(heights[i] - heights[i - 1]);
            int r = Integer.MAX_VALUE;
            if (i > 1) {
                r = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            prev2 = prev;
            prev = Math.min(l, r);
        }

        return prev;
    }
}