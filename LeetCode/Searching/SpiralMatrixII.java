package DSApractice.LeetCode.Searching;

import java.util.List;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;

        int[][] arr = generateMatrix(n);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j ++)
                System.out.print(arr[i][j] + " ");

    }

    static int[][] generateMatrix(int n) {
        // We divide the problem in 4 steps right, down, left, up

        int[][] list = new int[n][n];


        int m = n;
        int up = 0, left = 0, index = 1;
        int down = m - 1, right = m - 1;
        // this makes the boundaries

        while (index <= m * m) {
            // 1st -> right
            for (int j = left; j <= right && index <= m * m; j++)
                list[up][j] = index++;

            // 2nd -> down
            for (int i = up + 1; i <= down - 1 && index <= m * m; i++) // down - 1 => the next condition starts from down
                list[i][right] = index++;

            // 3rd -> left
            for (int j = right; j >= left && index <= m * m; j--)
                list[down][j] = index++;

            // 4th -> up
            for (int i = down - 1; i >= up + 1 && index <= m * m; i--) // up + 1 => up row elements were already cover
                list[i][left] = index++;

            // update the borders
            left++; right--; up++; down--;
        }

        return list;
    }
}