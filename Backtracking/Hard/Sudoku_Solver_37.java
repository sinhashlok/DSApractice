package DSApractice.Backtracking.Hard;

public class Sudoku_Solver_37 {
//    public static void main(String[] args) {
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','.','2','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'},
//        };
//
//        solveSudoku(board);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                System.out.print(board[i][j] + ", ");
//            }
//            System.out.println();
//        }
//    }

    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;


        helper(board, m, n);
    }

    private boolean helper(char[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == '.') {

                    for (int x = 1; x <= 9; x++) {
                        if (checkRow(board, i, n, x) && checkSubMatrix(board, i, j, x) && checkCol(board, j, m, x)) {
                            board[i][j] = (char)(x + '0');
                            if (helper(board, m, n)) {
                                break;
                            }
                            // backtrack;
                            board[i][j] = '.';
                        }
                    }

                    // check again if filled or not
                    if (board[i][j] == '.') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int j, int m, int x) {
        char ch = (char)(x + '0');
        for (int i = 0; i < m; i++) {
            if (board[i][j] == ch) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRow(char[][] board, int i, int n, int x) {
        char ch = (char)(x + '0');
        for (int j = 0; j < n; j++) {
            if (board[i][j] == ch) {
                return false;
            }
        }

        return true;
    }

    private boolean checkSubMatrix(char[][] board, int m, int n, int x) {
        m = (m / 3) * 3;
        n = (n / 3) * 3;
        char ch = (char)(x + '0');
        for (int i = m; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}