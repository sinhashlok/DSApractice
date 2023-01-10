// https://leetcode.com/problems/power-of-two/

package DSApractice.LeetCode.Math.Easy;

public class Power_of_Two_231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}