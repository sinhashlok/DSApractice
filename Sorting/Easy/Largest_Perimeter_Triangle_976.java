// https://leetcode.com/problems/largest-perimeter-triangle/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.Arrays;

public class Largest_Perimeter_Triangle_976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; --i) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        return 0;
    }
}