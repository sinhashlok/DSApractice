package DSApractice.Arrays.Medium;

public class Subarray_Product_Less_Than_K_713 {
    public static void main(String[] args) {
        int[] arr = {10,5,101,2,6};
        System.out.println(numSubarrayProductLessThanK(arr, 100));
    }

    static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int product = 1, count = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];

            while (product >= k) {
                product /= nums[l++];
            }

            count += r - l + 1;
        }

        return count;
    }
}