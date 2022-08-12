// https://leetcode.com/problems/spiral-matrix-ii/

package DSApractice.Arrays.Medium;

public class Spiral_Matrix_II_59 {


    // We divide the problem in 4 steps right, down, left, up
    public int[][] generateMatrix(int n) {

        int[][] list = new int[n][n];

        int m = n;
        int up = 0, left = 0, index = 1;
        int down = m - 1, right = m - 1;
        // this makes the boundaries

        while (index <= m * m) {
            // 1st -> right
            for (int j = left; j <= right && index <= m * m; j++)
                list[up][j] = index++;

            // 2nd -> down --- down - 1 => the next condition starts from down
            for (int i = up + 1; i <= down - 1 && index <= m * m; i++)
                list[i][right] = index++;

            // 3rd -> left
            for (int j = right; j >= left && index <= m * m; j--)
                list[down][j] = index++;

            // 4th -> up --- up + 1 => up row elements were already cover
            for (int i = down - 1; i >= up + 1 && index <= m * m; i--)
                list[i][left] = index++;

            // update the borders
            left++; right--; up++; down--;
        }

        return list;
    }
}
