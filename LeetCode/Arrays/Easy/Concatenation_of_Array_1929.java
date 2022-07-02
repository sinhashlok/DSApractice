// https://leetcode.com/problems/concatenation-of-array/
package DSApractice.LeetCode.Arrays.Easy;

public class Concatenation_of_Array_1929 {

    // Solution
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            arr[i] = nums[i];
            arr[i + nums.length] = nums[i];
        }

        return arr;
    }
}
