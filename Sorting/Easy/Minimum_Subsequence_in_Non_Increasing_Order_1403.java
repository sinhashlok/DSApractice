package DSApractice.Sorting.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Subsequence_in_Non_Increasing_Order_1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int ans = 0, index = nums.length - 1;
        while (ans <= sum) {
            ans += nums[index];
            sum -= nums[index];

            list.add(nums[index]);
            index--;
        }

        return list;
    }
}