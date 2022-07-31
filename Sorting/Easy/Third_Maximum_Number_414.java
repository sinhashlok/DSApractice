// https://leetcode.com/problems/third-maximum-number/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.Arrays;

public class Third_Maximum_Number_414 {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        // sort and start from last element

        int index = 2;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                index--;
            } else {
                continue;
            }

            if (index == 0) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

}
