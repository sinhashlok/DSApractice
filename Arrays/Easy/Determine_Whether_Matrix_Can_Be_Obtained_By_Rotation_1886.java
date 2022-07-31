package DSApractice.LeetCode.Arrays.Easy;

public class Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation_1886 {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = target.length;

        boolean[] c = new boolean[4];
        for (int i = 0; i < 4; i++)
            c[i] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] != target[i][j])
                    c[0] = false;
                if(mat[i][j] != target[n-j-1][i])
                    c[1] = false;
                if(mat[i][j] != target[n-i-1][n-j-1])
                    c[2] = false;
                if(mat[i][j] != target[j][n-i-1])
                    c[3] = false;
            }
        }

        return c[0]||c[1]||c[2]||c[3];
    }
}
