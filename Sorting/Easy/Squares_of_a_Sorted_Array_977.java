// https://leetcode.com/problems/squares-of-a-sorted-array/

package DSApractice.LeetCode.Sorting.Easy;

public class Squares_of_a_Sorted_Array_977 {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0, j = nums.length - 1;
        for (int p = nums.length - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {
                result[p] = nums[j] * nums[j];
                j--;
            }
        }

        return result;
    }

}