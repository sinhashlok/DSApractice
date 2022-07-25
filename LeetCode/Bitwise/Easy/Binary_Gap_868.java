// https://leetcode.com/problems/binary-gap/

package DSApractice.LeetCode.Bitwise.Easy;

public class Binary_Gap_868 {

    public int binaryGap(int n) {
        int count = 0, res = 0;
        while ((n & 1) != 1 && n != 0) {    // to find the first 1 bit
            n >>= 1;
        }

        while (n != 0) {
            if ((n & 1) == 1) { // everytime one occurs, store the length
                res = Math.max(count, res);
                count = 0;
            }
            count += 1;
            n >>= 1;
        }

        return res;
    }
}