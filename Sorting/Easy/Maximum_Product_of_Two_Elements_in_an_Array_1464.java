// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

package DSApractice.LeetCode.Sorting.Easy;

public class Maximum_Product_of_Two_Elements_in_an_Array_1464 {

    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = max1;

        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}