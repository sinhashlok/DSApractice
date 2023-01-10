// https://leetcode.com/problems/two-sum/

package DSApractice.Arrays.Easy;

import java.util.HashSet;

public class Two_Sum_1 {


    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i]))
                return new int[] {i, index(nums, target - nums[i], i)};
            else
                set.add(nums[i]);
        }

        return new int[] {-1, -1};
    }

    public int index(int[] nums, int x, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == k)
                continue;
            if (x == nums[i])
                return i;
        }

        return -1;
    }
}
