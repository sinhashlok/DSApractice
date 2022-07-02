// https://leetcode.com/problems/reshape-the-matrix/

package DSApractice.LeetCode.Arrays.Easy;

public class Reshape_the_Matrix_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (n * m != r * c)
            return mat;

        int[][] res = new int[r][c];
        for (int i = 0, k = 0, l = 0; i < m; i++) {
            for (int j = 0; j < n; j++, l++) {
                if (l == c) {
                    k++;
                    l = 0;
                }
                res[k][l] = mat[i][j];
            }
        }
        return res;
    }
}
