package DSApractice.LeetCode.Sorting.Medium;

import java.util.*;

public class Three_Sum_15 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = threeSum(arr);

        for (List<Integer> i : list) {
            for (Integer j : i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
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