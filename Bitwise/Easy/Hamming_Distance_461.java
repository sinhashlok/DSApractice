// https://leetcode.com/problems/hamming-distance/

package DSApractice.Bitwise.Easy;

public class Hamming_Distance_461 {

    public int hammingDistanceLeet(int x, int y) {
        // x XOR(^) y => 1 ^ 0 = 1
        // so all the hamming bits(say, with different bits), will 1.
        // bitCount will return the number of set bits in (x^y)
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance(int x, int y) {
        int count = 0;

        while (x != 0 || y != 0) {
            // if both right most bit are not equal, increment count
            if ((x & 1) != (y & 1)) {
                count += 1;
            }

            // right shift both numbers
            x >>= 1;
            y >>= 1;
        }

        return count;
    }
}