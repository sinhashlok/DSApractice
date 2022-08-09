// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

package DSApractice.Searching.Hard;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, m = 0;

        while (l < r) {
            m = l + (r - l) / 2;

            while (nums[l] == nums[r] && l != r - 1) {
                if (l == r) {
                    return nums[l];
                }

                if (nums[l] < nums[l + 1] && nums[r] < nums[r - 1]) {
                    return nums[l];
                }

                l++;
                r--;
            }

            if (nums[m] >= nums[l]) {
                if (nums[m] > nums[r]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            else {
                r = m;
            }
        }

        return nums[l];
    }
}