package DSApractice.Greedy.Medium;

public class Maximum_Subarray_53 {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i-1] + nums[i]);
            res = Math.max(res, nums[i]);
        }

        return res;
    }
}