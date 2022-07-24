// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

package DSApractice.LeetCode.Arrays.Easy;

public class How_Many_Numbers_Are_Than_the_Current_Number_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int c : nums)
            count[c] ++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        for (int i = 0; i < res.length; i++)
        {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }

        return res;
    }
}
