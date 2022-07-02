package DSApractice.LeetCode.Arrays;

import java.util.Arrays;

public class NumberofGoodPairs {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2};

        System.out.println(numIdenticalPairs(arr));
    }

    static int numIdenticalPairs(int[] nums) {
        int res = 0, count[] = new int[101];
        for (int a: nums) {
            res += count[a]++;  // this first used the current value stores, then increments it
        }
        return res;

        // My approach
//        Arrays.sort(nums);
//
//        int l = 0, h = 0, ans = 0;
//        boolean car = false;
//        for (int i = 1; i < nums.length; i++)
//        {
//            if (nums[i] != nums[i-1])
//            {
//                int n = h - l;
//                ans += n*(n+1)/2;
//                l = i;
//            }
//            h++;
//        }
//
//        if (nums[nums.length - 1] == nums[nums.length - 2])
//        {
//            int n = h - l;
//            ans += n*(n+1)/2;
//        }
//
//        return ans;
    }
}
