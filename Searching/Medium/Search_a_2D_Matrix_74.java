// https://leetcode.com/problems/search-a-2d-matrix/description/

package DSApractice.Searching.Medium;

public class Search_a_2D_Matrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search every row
        int i = 0;
        while (i < matrix.length) {
            if (target <= matrix[i][matrix[0].length - 1] && binarySearchRow(matrix[i], target)) {
                    return true;
            }

            i++;
        }

        return false;
    }

    private boolean binarySearchRow(int[] row, int target) {
        int l = 0, r = row.length - 1;
        int mid = 0;

        while (l <= r) {
            mid = ((r - l) / 2) + l;

            if (row[mid] == target) {
                return true;
            }

            if (row[mid] > target) {
                r--;
            } else {
                l++;
            }
        }

        return false;
    }
}