// https://leetcode.com/problems/binary-number-with-alternating-bits/

package DSApractice.LeetCode.Bitwise.Easy;

public class Binary_Number_with_Alternating_Bits_693 {

        // My approach
    public boolean hasAlternatingBitsMy(int n) {
        int prev = (n & 1); // keep track of previous bit
        n >>= 1;
        while (n != 0) {
            if ((n & 1) == prev) {  // compare previous bit and current bit
                return false;
            }

            prev = n & 1;
            n >>= 1;
        }

        return true;
    }

        // LeetCode
    public boolean hasAlternatingBitsLeet(int n) {
        String bits = Integer.toBinaryString(n);    // converts int, to bit string

        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

}