// https://leetcode.com/problems/sort-array-by-parity-ii/

package DSApractice.LeetCode.Sorting.Easy;

public class Sort_Array_By_Parity_II_922 {

    public int[] sortArrayByParityII(int[] nums) {
        int index = 0;

        // only check for odd indices
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] % 2 == 0) { // if even number
                // find even indices without even number
                while (nums[index] % 2 == 0) {
                    index += 2;
                }

                swap(nums, i, index);   // swap
            }

            // if index is at the last even index, terminate, solution already reached
            if (index == nums.length - 2) {
                break;
            }
        }

        return nums;
    }

    public void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

}