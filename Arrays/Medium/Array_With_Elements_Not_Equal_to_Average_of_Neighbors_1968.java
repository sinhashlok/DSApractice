package DSApractice.Arrays.Medium;

import java.util.Arrays;

public class Array_With_Elements_Not_Equal_to_Average_of_Neighbors_1968 {

    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
        }

        return nums;
    }
}