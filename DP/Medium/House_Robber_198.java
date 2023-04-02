package DSApractice.DP.Medium;

public class House_Robber_198 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = 0;
        int prev1 = nums[0];

        for (int i = 2; i < nums.length + 1; i++) {
            int x = Math.max(prev1, prev2 + nums[i - 1]);
            prev2 = prev1;
            prev1 = x;
        }

        return prev1;
    }
}