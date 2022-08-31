package DSApractice.DP.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Min_Cost_Climbing_Stairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // top down - recursion + memorization
        // Step 1
//        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));
//        int ans = Math.min(solution1(cost, n - 1, dp), solution1(cost, n - 2, dp));
//        return ans;

        return solution2(cost, n);
    }

    // top down - recursion + memorization
    private int solution1(int[] cost, int n, List<Integer> dp) {
        // base case
        if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }

        // step 3
        if (dp.get(n) != -1) {
            return dp.get(n);
        }

        // step 2
        dp.set(n, cost[n] + Math.min(solution1(cost, n - 1, dp), solution1(cost, n - 2, dp)));

        return dp.get(n);
    }

    // bottom up - tabulation
    private int solution2(int[] cost, int n) {
        // step 1 - creation of dp array
//        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // step 2 - base case analysis
        dp[0] = cost[0];
        dp[1] = cost[1];

        // step 3
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // space optimization
    private int solution4(int[] cost, int n) {
        // step 2 - base case analysis
        int prev2 = cost[0];
        int prev1 = cost[1];

        // step 3
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev2, prev1);
    }
}