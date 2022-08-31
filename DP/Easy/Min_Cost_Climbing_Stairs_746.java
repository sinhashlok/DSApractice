package DSApractice.DP.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Min_Cost_Climbing_Stairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Step 1
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));
        int ans = Math.min(solution(cost, n - 1, dp), solution(cost, n - 2, dp));

        return ans;
    }

    private int solution(int[] cost, int n, List<Integer> dp) {
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
        dp.set(n, cost[n] + Math.min(solution(cost, n - 1, dp), solution(cost, n - 2, dp)));

        return dp.get(n);
    }
}