package DSApractice.DP.Medium;

public class House_Robber_II_213 {

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int first2 = 0;
        int first1 = nums[0];

        for (int i = 2; i < nums.length; i++) {
            int x = Math.max(first1, first2 + nums[i - 1]);
            first2 = first1;
            first1 = x;
        }

        int sec2 = 0;
        int sec1 = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int x = Math.max(sec1, sec2 + nums[i]);
            sec2 = sec1;
            sec1 = x;
        }

        return Math.max(first1, sec1);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int f = helper(nums, 0, nums.length - 2, nums.length - 1);
        int s = helper(nums, 1, nums.length - 1, nums.length - 1);

        return Math.max(f, s);
    }

    private int helper(int[] nums, int start, int end, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[start];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1 + start]);
        }

        return dp[n];
    }
}