package DSApractice.Searching.Medium;

import java.util.Arrays;

public class Find_a_Peak_Element_II_1901 {

    /* credits: https://leetcode.com/problems/find-a-peak-element-ii/discuss/1338377/JavaC%2B%2B-Detailed-explanation
    *
    *
    * The algorithm is as follows:
      1. Pick the middle column.
      2. Find the global maximum in the column.
      3. If the row-neighbours of this element are smaller, then we found a 2D peak.
         Else, we recurse at the right-half of the matrix if the right-neighbour was bigger,
         and left-half of the matrix if the left-neighbour was bigger.
    *
    * if matrix[i][j + 1] > matrix[i][j]
    * then matrix[i][j + 1] is bigger than all elements in column j
    * thus maximum of column j + 1 is bigger than its row-neighbour in column j
    * thus, there exists some peak in the right half of the matrix
    *
    * the overall Time complexity is O(n * log(m))
    * n = number of rows, m = number of columns
    * */

    public int[] findPeakGrid(int[][] mat) {
        int l = 0, r = mat[0].length - 1, mid;

        while (l <= r) {
            mid = l + (r - l) / 2;

            int max_row = 0;
            // we find the largest element in the middle column
            for (int i = 0; i < mat.length; i++) {
                if (mat[max_row][mid] < mat[i][mid]) {
                    max_row = i;
                }
            }

            // we compare the largest with the just prev and next element of that row
            if ((mid == 0 || mat[max_row][mid] > mat[max_row][mid - 1]) &&
                    (mid == mat[0].length - 1 || mat[max_row][mid] > mat[max_row][mid + 1])) {
                return new int[] {max_row, mid};
            } else if (mid > 0 && mat[max_row][mid - 1] > mat[max_row][mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return new int[] {-1, -1};
    }
}