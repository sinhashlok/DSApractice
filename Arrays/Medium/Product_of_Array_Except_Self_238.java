// https://leetcode.com/problems/product-of-array-except-self/

package DSApractice.Arrays.Medium;

import java.util.Arrays;

public class Product_of_Array_Except_Self_238 {

    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        int prefix = nums[0];
        int postfix = nums[nums.length - 1];

        // prefix
        for (int i = 1; i < nums.length; i++) {
            arr[i] *=  prefix;
            prefix *= nums[i];
        }

        // postfix
        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] *= postfix;
            postfix *= nums[i];
        }

        return arr;
    }
}
