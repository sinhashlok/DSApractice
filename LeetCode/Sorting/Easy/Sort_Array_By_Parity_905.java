// https://leetcode.com/problems/sort-array-by-parity/

package DSApractice.LeetCode.Sorting.Easy;

public class Sort_Array_By_Parity_905 {

    public int[] sortArrayByParity(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) { // even element
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }
}