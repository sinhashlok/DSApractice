package DSApractice.LeetCode.Searching;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr= {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        List<Integer> list = spiralOrder(arr);

        for (Integer x : list)
            System.out.print(x + " ");
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        // We divide the problem in 4 steps right, down, left, up

        List<Integer> list = new ArrayList<>();

        int n = matrix.length, m = matrix[0].length;
        int up = 0, left = 0;
        int down = n - 1, right = m - 1;
        // this makes the boundaries

        while (list.size() < n * m) {
            // 1st -> right
            for (int j = left; j <= right && list.size() < n * m; j++)
                list.add(matrix[up][j]);

            // 2nd -> down
            for (int i = up + 1; i <= down - 1 && list.size() < n * m; i++) // down - 1 => the next condition starts from down
                list.add(matrix[i][right]);

            // 3rd -> left
            for (int j = right; j >= left && list.size() < n * m; j--)
                list.add(matrix[down][j]);

            // 4th -> up
            for (int i = down - 1; i >= up + 1 && list.size() < n * m; i--) // up + 1 => up row elements were already cover
                list.add(matrix[i][left]);

            // update the borders
            left++; right--; up++; down--;
        }

        return list;
    }
}
