// https://leetcode.com/problems/single-number/

package DSApractice.LeetCode.Bitwise.Easy;

public class Single_Number_136 {

    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int i : nums) {
            xor ^= i;
        }

        return xor;
    }
}