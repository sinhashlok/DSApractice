// https://leetcode.com/problems/transpose-matrix/

package DSApractice.LeetCode.Arrays.Easy;

public class Transpose_Matrix_867 {

    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[i][j] = matrix[j][i];
            }
        }

        return res;
    }
}
