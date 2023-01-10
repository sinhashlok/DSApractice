// https://leetcode.com/problems/power-of-four/

package DSApractice.LeetCode.Math.Easy;

public class Power_of_Four_342 {

    public boolean isPowerOfFour(int n) {
        if (n < 1)
            return false;

        if (n == 1)
            return true;

        return ( (n%4 == 0) && isPowerOfFour(n/4));
    }
}