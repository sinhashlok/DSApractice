package DSApractice.Searching.Medium;

public class Search_a_2D_Matrix_II_240 {

    // Leetcode
    /*
    * initialize the current position to top right corner,
    * if the target is greater than the value in current position, then the target can not be in entire row of current
    * position because the row is sorted,
    *
    * if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too.
    *
    * We can rule out one row or one column each time, so the time complexity is O(m+n)*/
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        } else if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
            return true;
        }

        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    // My Approach - little slow
    /*
    * linear search to find THE potential row / rows in which target could exist
    * binary search in that row*/
    public boolean searchMatrixMy(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        } else if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
            // if target is == smallest or the largest element
            return true;
        }

        for (int[] ints : matrix) {
            if (ints[0] > target) {
                return false;
            }

            // we go through every row checking if the target lies in the row
            // if yes, we use binary search to find
            if (target <= ints[ints.length - 1]) {
                if (binarySearch(ints, target)) {
                    return true;
                }
            }
            // we keep doing binary search till we do not get the target
            // else return false
        }

        return false;
    }
    private boolean binarySearch(int[] arr,  int x) {
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;

            if (arr[m] == x) {
                return true;
            }

            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}