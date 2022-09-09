// https://leetcode.com/problems/product-of-array-except-self/

package DSApractice.Arrays.Medium;

public class Product_of_Array_Except_Self_238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        // Calc lefts and store in res
        for (int i = 1; i < nums.length; i++)
            res[i] = res[i-1] * nums[i-1];

        // Calc right and product from end of the array
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;

    }
}
