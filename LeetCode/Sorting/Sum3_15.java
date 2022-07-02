package DSApractice.LeetCode.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3_15 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = threeSum(arr);

        for (List<Integer> integers : list)
            System.out.println("[" + integers.get(0) + ", " + integers.get(1) + ", " + integers.get(2) + "]");
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++)
        {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1]))
            {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi)
                {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        while (lo < hi && nums[lo] == nums[lo+1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi-1])
                            hi--;

                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}
