// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

package DSApractice.LeetCode.Searching.Easy;

public class Count_Negative_Numbers_in_a_Sorted_Matrix_1351 {

    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int r = m - 1, c = 0, cnt = 0;  //we are starting the count from bottom row

        while (r >= 0 && c < n)
        {
            if (grid[r][c] < 0)
            {
                --r; // take the entire row
                cnt += n - c;   // the elements that are remaining on right are -ve
            }
            else
            {
                // column-wise decreasing, even when we move up
                // the just above element will be starting negative element or the next one's
                ++c;
            }
        }
        return cnt;
    }

}
