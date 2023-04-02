package DSApractice.DP.Medium;

import java.util.Arrays;

public class Ninjas_Training_CN {
    // tabulation
        public static int ninjaTrainingTabulation(int n, int points[][]) {
            int[][] dp = new int[n][4];

            dp[0][0] = Math.max(points[0][1], points[0][2]);
            dp[0][1] = Math.max(points[0][0], points[0][2]);
            dp[0][2] = Math.max(points[0][1], points[0][0]);
            dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

            for (int day = 1; day < n; day++) {
                for (int last = 0; last < 4; last++) {

                    for (int task = 0; task < 3; task++) {
                        if (task != last) {
                            int x = points[day][task] + dp[day - 1][task];
                            dp[day][last] = Math.max(dp[day][last], x);
                        }
                    }
                }
            }

            return dp[n - 1][3];
        }


        // Memoize
        public static int ninjaTrainingMemoize(int n, int points[][]) {

            int[][] dp = new int[n][4];
            for (int[] i: dp) {
                Arrays.fill(i, -1);
            }

            return helper(n - 1, 3, points, dp);
        }

        private static int helper(int n, int i, int[][] points, int[][] dp) {
            if (n == 0) {
                int t = 0;
                for (int j = 0; j < 3; j++) {
                    if (j != i) {
                        t = Math.max(t, points[n][j]);
                    }
                }

                return t;
            }

            if (dp[n][i] != -1) {
                return dp[n][i];
            }

            int t = 0;
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    int x = points[n][j] + helper(n - 1, j, points, dp);
                    t = Math.max(t, x);
                }
            }

            dp[n][i] = t;
            return dp[n][i];
        }

}