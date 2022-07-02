package DSApractice.LeetCode.Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeroes(arr);

        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }


    // My Approach
//    static void setZeroes(int[][] matrix) {
//        ArrayList<ArrayList<Integer> > x = new ArrayList<ArrayList<Integer> >();
//
//        for (int i = 0; i < matrix.length; i++)
//            for (int j = 0; j < matrix[0].length; j++)
//                if (matrix[i][j] == 0)
//                    x.add(new ArrayList<Integer>(Arrays.asList(i, j)));
//
//        for (Integer i = 0; i < x.size(); i++) {
//            // for row
//            for (int j = 0; j < matrix[0].length; j++)
//                matrix[(int) x.get(i).get(0)][j] = 0;
//
//            // for column
//            for (int j = 0; j < matrix.length; j++)
//                matrix[j][(int) x.get(i).get(1)] = 0;
//        }
//    }


    static void setZeroes(int[][] matrix) {
                boolean isCol = false;
                int R = matrix.length;
                int C = matrix[0].length;

                for (int i = 0; i < R; i++) {

                    // Since first cell for both first row and first column is the same i.e. matrix[0][0].
                    // it can matrix zero
                    // We can use an additional variable for either the first row/column.
                    // For this solution we are using an additional variable for the first column
                    // and using matrix[0][0] for the first row.
                    if (matrix[i][0] == 0) {
                        isCol = true;
                    }

                    for (int j = 1; j < C; j++) {
                        // If an element is zero, we set the first element of the corresponding row and column to 0
                        if (matrix[i][j] == 0) {
                            matrix[0][j] = 0;
                            matrix[i][0] = 0;
                        }
                    }
                }

                // Iterate over the array once again and using the first row and first column, update the elements.
                // not starting from border elements
                for (int i = 1; i < R; i++) {
                    for (int j = 1; j < C; j++) {
                        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                            matrix[i][j] = 0;
                        }
                    }
                }

                // See if the first row needs to be set to zero as well
                if (matrix[0][0] == 0) {
                    for (int j = 0; j < C; j++) {
                        matrix[0][j] = 0;
                    }
                }

                // See if the first column needs to be set to zero as well
                if (isCol) {
                    for (int i = 0; i < R; i++) {
                        matrix[i][0] = 0;
                    }
                }
    }
}
