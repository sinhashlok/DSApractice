// https://leetcode.com/problems/reverse-bits/

package DSApractice.LeetCode.Bitwise.Easy;

public class Reverse_Bits_190 {

    public int reverseBits(long n) {
        int result = 0;

        for(int i = 0; i < 32; i++) {
            result <<= 1;   // left shift previous bits
            result += n & 1;//  add the new bit;

            n >>= 1;        // remove a bit from original number
        }

        return result;
    }
}