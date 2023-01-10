// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

package DSApractice.Bitwise.Easy;

public class Sum_of_All_Subset_XOR_Totals_1863 {
    public static void main(String[] args) {
        int[] arr = {5,1,6};
        System.out.println(subsetXORSum(arr));
    }

        // My approach
    public int subsetXORSumMY(int[] nums) {
        int sum = 0;

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            int x = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0)
                    x = x ^ nums[j];
            }
            sum += x;
        }

        return sum;
    }

    static int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    static int helper(int[] nums, int index, int currentXor) {
        // return currentXor when all elements in nums are already considered
        if (index == nums.length) return currentXor;    // Base condition

        // calculate sum of XOR with current element
        int withElement = helper(nums, index + 1, currentXor ^ nums[index]);

        // calculate sum of XOR without current element
        int withoutElement = helper(nums, index + 1, currentXor);

        // return sum of XORs from recursion
        return withElement + withoutElement;
    }
}
