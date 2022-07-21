// https://leetcode.com/problems/kth-missing-positive-number/

package DSApractice.LeetCode.Searching.Easy;

public class Kth_Missing_Positive_Number_1539 {

    public int findKthPositive(int[] A, int k) {
        int l = 0, r = A.length, m;

        while (l < r) {
            m = l + (r - l) / 2;

            if (A[m] - 1 - m < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l + k;
    }
}
