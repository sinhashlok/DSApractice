package DSApractice.Searching.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class The_K_Weakest_Rows_in_a_Matrix_1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[mat.length];

        for (int i = 0; i < arr.length; i++) {
            int j = binSearch(mat[i]);
            arr[i] = j * mat.length + i;
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % mat.length;
        }


        return Arrays.copyOfRange(arr, 0, k);
    }
    public int binSearch(int[] mat) {
        int l = 0, r = mat.length - 1, m = 0;

        while (l < r) {
            m = l + (r - l) / 2;

            if (mat[m] == 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (mat[l] == 1) {
            return l + 1;
        }
        return l;
    }
}