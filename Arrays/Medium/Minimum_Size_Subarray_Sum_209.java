package DSApractice.Arrays.Medium;

public class Minimum_Size_Subarray_Sum_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // as soon as, sum >= target, we start moving the left pointer
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - left);  // i + 1 - left => window length
                sum -= nums[left++];
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

        // My approach
    public int minSubArrayLenMy(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0, windowlen = 0, res = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (sum < target) {
                if (i == nums.length) {
                    break;
                }
                sum += nums[i];

                windowlen++;
                i++;
            } else {
                res = Math.min(res, windowlen);

                sum -= nums[j];
                j++;
                windowlen--;
            }

            if (res == 1) {
                return 1;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}