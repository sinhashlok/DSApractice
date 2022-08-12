// https://leetcode.com/problems/spiral-matrix/

package DSApractice.Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {

    // We divide the problem in 4 steps right, down, left, up
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int n = matrix.length, m = matrix[0].length;
        int up = 0, left = 0;
        int down = n - 1, right = m - 1;
        // this makes the boundaries

        while (list.size() < n * m) {
            // 1st -> right
            for (int j = left; j <= right && list.size() < n * m; j++)
                list.add(matrix[up][j]);

            // 2nd -> down  --- down - 1 => the next condition starts from down
            for (int i = up + 1; i <= down - 1 && list.size() < n * m; i++)
                list.add(matrix[i][right]);

            // 3rd -> left
            for (int j = right; j >= left && list.size() < n * m; j--)
                list.add(matrix[down][j]);

            // 4th -> up --- up + 1 => up row elements were already cover
            for (int i = down - 1; i >= up + 1 && list.size() < n * m; i--)
                list.add(matrix[i][left]);

            // update the borders
            left++; right--; up++; down--;
        }

        return list;
    }
}
