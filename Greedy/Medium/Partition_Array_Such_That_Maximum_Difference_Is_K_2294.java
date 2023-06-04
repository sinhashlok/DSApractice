package DSApractice.Greedy.Medium;

import java.util.Arrays;

public class Partition_Array_Such_That_Maximum_Difference_Is_K_2294 {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;
        int l = nums.length - 1;
        int s = l - 1;

        while (s >= 0) {
            if (nums[l] - nums[s] <= k) {
                s--;
            } else {
                l = s;
                s = l - 1;
                count++;
            }
        }

        return count + 1;
    }
}