// https://leetcode.com/problems/number-of-1-bits/

package DSApractice.Bitwise.Easy;

public class Number_of_One_Bits_191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }
}