// https://leetcode.com/problems/jump-game-ii/description/
package DSApractice.DP.Medium;

import java.util.Arrays;

public class Jump_Game_II_45 {

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int l = 0, r = 0, i = 0;
        int count = 0;

        while (l < nums.length) {
            int x = helper(nums, l, r);

            l = r + 1;
            r = x;
            count++;

            if (r >= nums.length - 1) {
                return count;
            }
        }

        return -1;
    }

    private static int helper(int[] nums, int l, int r) {
        int i = l;
        int max = 0;
        while (i <= r) {
            max = Math.max(max, nums[i] + i);
            i += 1;
        }

        return max;
    }
}