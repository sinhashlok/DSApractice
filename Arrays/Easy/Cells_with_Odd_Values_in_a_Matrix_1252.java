// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

package DSApractice.LeetCode.Arrays.Easy;

public class Cells_with_Odd_Values_in_a_Matrix_1252 {
    public static void main(String[] args) {
        int[][] arr = {
                {0,1},
                {1,1}
        };

            // MY APPROACH
//        System.out.println(oddCellsMY(48, 37, arr));
        System.out.println(oddCells(2, 3, arr));
    }

    static int oddCellsMY(int m, int n, int[][] indices) {
        int[][] res = new int[m][n];

        for (int[] index : indices)
            for (int j = 0; j < n; j++)
                res[index[0]][j] += 1;

        for (int[] index : indices)
            for (int j = 0; j < m; j++)
                res[j][index[1]] += 1;

        int count = 0;
        for (int[] re : res) {
            for (int i : re) {
                if (i % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
    static int oddCells(int m, int n, int[][] indices) {
        int count = 0;
        int[] row = new int [m];
        int[] col = new int [n];
        for(int[] x : indices) {
            row[x[0]]++;
            col[x[1]]++;
        }
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
