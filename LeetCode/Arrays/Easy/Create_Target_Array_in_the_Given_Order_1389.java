// https://leetcode.com/problems/create-target-array-in-the-given-order/

package DSApractice.LeetCode.Arrays.Easy;

public class Create_Target_Array_in_the_Given_Order_1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            res[i] = nums[i];
            if (i == index[i])
                continue;
            else
            {
                int ind = i, temp;
                while (ind != index[i])
                {
                    temp = res[ind - 1];
                    res[ind - 1] = res[ind];
                    res[ind] = temp;
                    ind--;
                }
            }
        }

        return res;
    }
}
