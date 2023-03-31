package DSApractice.DP.Medium;

public class Target_Sum_494 {
    public static void main(String[] args) {
        int[] arr = {1,0,0};
        System.out.println(findTargetSumWays(arr, 1));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum < target || (sum + target) % 2 != 0) {
            return 0;
        }

        sum = (sum - target) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][sum + 1];
        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}