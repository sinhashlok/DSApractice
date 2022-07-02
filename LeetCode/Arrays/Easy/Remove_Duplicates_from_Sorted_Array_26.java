// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package DSApractice.LeetCode.Arrays.Easy;

public class Remove_Duplicates_from_Sorted_Array_26 {

    public int removeDuplicates(int[] nums) {
        int k = 0, x = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                k++;
                nums[x++] = nums[i-1];
            }
        }

        nums[x] = nums[nums.length - 1];
        return ++k;
    }
}
