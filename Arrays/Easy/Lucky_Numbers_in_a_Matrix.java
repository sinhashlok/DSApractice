// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

package DSApractice.LeetCode.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class Lucky_Numbers_in_a_Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };

        List<Integer> res = luckyNumbers(mat);
        System.out.println(res);
    }

    static List<Integer> luckyNumbers(int[][] matrix) {
        int[] minEachRow = new int[matrix.length];
        int[] maxEachCol = new int[matrix[0].length];

        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        //Finding MIN element of  each row and storing in an array
        for (int i = 0; i < matrix.length; i++) {
            minElement = Integer.MAX_VALUE ;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                }
            }

            // update after each row
            minEachRow[i] = minElement;
        }

        //Finding MAX element of each column and storing in an array
        for(int i=0; i< matrix[0].length;i++) {
            maxElement = Integer.MIN_VALUE ;
            for (int[] ints : matrix) {
                if (ints[i] > maxElement) {
                    maxElement = ints[i];
                }
            }

            // update after each col
            maxEachCol[i] = maxElement ;
        }

        //Initializing an ArrayList
        List<Integer> ans = new ArrayList<>();

        // Iterate through
        for (int k : minEachRow) {
            for (int i : maxEachCol) {
                if (k == i) {
                    ans.add(k);
                }
            }
        }

        return ans;
    }
}
