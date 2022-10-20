package DSApractice.Matrix.Medium;

public class Valid_Sudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0, j = 0; i < 9 && j < 9; i++, j++) {
            boolean[] col = new boolean[10];
            for (int x = 0; x < 9; x++) {   // column
                char ch = board[i][x];
                if (ch == '.') {
                    continue;
                } else {
                    if (col[ch - '0']) {
                        return false;
                    }

                    col[ch - '0'] = true;
                }
            }

            boolean[] row = new boolean[10];
            for (int x = 0; x < 9; x++) {   // row
                char ch = board[x][j];
                if (ch == '.') {
                    continue;
                } else {
                    if (row[ch - '0']) {
                        return false;
                    }

                    row[ch - '0'] = true;
                }
            }
        }

        return true;
    }
}