// https://leetcode.com/problems/sqrtx/

package DSApractice.LeetCode.Searching.Easy;

public class Sqrt_x_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(15));
    }

    static int mySqrt(int x) {
        long l = 0, h = x, mySq;
        int ans = -1, m;

        while (l <= h)
        {
            m = (int)(l + (h - l) / 2);
            mySq = (long)m * (long)m;

            if (mySq == x)
                return m;
            else if (mySq > x)
                h = m - 1;
            else
            {
                l = m + 1;
                ans = m; //  keep track of m, in case x is not perfect square
            }
        }

        return ans;
    }

}
