// https://leetcode.com/problems/diagonal-traverse/

package DSApractice.LeetCode.Arrays.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Diagonal_Traverse_498 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int[] res = ApproachONEfindDiagonalOrder(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }

//        int[] res2 = ApproachTWofindDiagonalOrder(arr);
//        for (int i : res2) {
//            System.out.print(i + " ");
//        }
    }

    static int[] ApproachONEfindDiagonalOrder(int[][] matrix) {
        /*
        Algorithm
        1. Initialize a result array that we will eventually return.
        2. We would have an outer loop that will go over each of the diagonals one by one.
            As mentioned before, the elements in the first row and the last column
            would actually be the heads of their corresponding diagonals.
        3. We then have an inner while loop that iterates over all the elements in the diagonal.
            We can calculate the number of elements in the corresponding diagonal by doing some math
            but we can simply iterate until one of the indices goes out of bounds.
        4. For each diagonal we will need a new list or dynamic array like data structure since we
            don't know what size to allocate. Again, we can do some math and calculate the size of that particular
            diagonal and allocate memory; but it's not necessary for this explanation.
        5. For odd numbered diagonals, we simply need to add the elements in our intermediary array,
            in reverse order to the final result array.
        */

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int N = matrix.length;
        int M = matrix[0].length;

        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {
                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The article says we have to reverse odd
            // numbered articles but here, the numbering is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }

        return result;
    }

    static int[] ApproachTWofindDiagonalOrder(int[][] matrix) {
        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N*M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }
}
