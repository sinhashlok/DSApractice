// https://leetcode.com/problems/single-element-in-a-sorted-array/

package DSApractice.LeetCode.Searching.Medium;

public class Single_Element_in_a_Sorted_Array_540 {

        // XOR
    public int singleNonDuplicateXOR(int[] nums) {
        int xor = 0;
        for (int x : nums)
            xor ^= x;

        return xor;
    }

        // Binary Search
    public int singleNonDuplicateBinarySearch(int[] nums) {
        int l = 0, r = nums.length - 1, m = 0;

        while (l < r) {
            m = l + (r - l) / 2;

            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                }
                else {
                    r = m - 1;
                }
            }
            else {
                if (nums[m] == nums[m + 1]) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
        }

        return nums[l];
    }
}