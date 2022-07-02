// https://leetcode.com/submissions/detail/712242117/
package DSApractice.LeetCode.Arrays.Easy;

public class Build_Array_from_Permutation_1920 {

    // Solution
    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[nums[i]];

        return arr;
    }
}
