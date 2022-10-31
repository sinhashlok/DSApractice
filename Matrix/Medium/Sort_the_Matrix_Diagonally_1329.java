package DSApractice.Matrix.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_the_Matrix_Diagonally_1329 {

    public int[][] diagonalSort(int[][] mat) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int x = i;
            int j = 0;
            for (; x < mat.length && j < mat[0].length; x++, j++) {
                list.add(mat[x][j]);
            }
            Collections.sort(list);

            x = i;
            j = 0;
            for (; x < mat.length && j < mat[0].length; x++, j++) {
                mat[x][j] = list.get(j);
            }
            list.clear();
        }

        for (int j = 1; j < mat[0].length; j++) {
            int x = j;
            int i = 0;
            for (; x < mat[0].length && i < mat.length; x++, i++) {
                list.add(mat[i][x]);
            }
            Collections.sort(list);

            x = j;
            i = 0;
            for (; x < mat[0].length && i < mat.length; x++, i++) {
                mat[i][x] = list.get(i);
            }
            list.clear();
        }

        return mat;
    }
}