package DSApractice.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallerThantheCurrentNumber {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // see constraints
        int[] res = new int[nums.length];

        for (int c : nums)
            count[c] ++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1]; // dimaag laagao

        for (int i = 0; i < res.length; i++)
        {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }

        return res;

            // My approach
//        List<Integer> a =  new ArrayList<>();   // create a new arraylist cause we can sort and get indexOf EASILY
//        for (Integer b : nums)
//            a.add(b);
//
//
//        Collections.sort(a);
//        int[] arr = new int[nums.length];   // for return
//
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            int j = a.indexOf(nums[i]); // find index of the given element in nums in sorted arraylist
//            arr[i] = j;
//        }
//
//        return arr;
    }
}
