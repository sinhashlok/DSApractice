package DSApractice.Recursion.Medium;

public class Word_Search_79 {

    public boolean exist(char[][] board, String word) {
        // flag matrix to keep track of previously visited elements
        boolean[][] flag = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) { // row
            for (int j = 0; j < board[i].length; j++) { // column

                if (word.charAt(0) == board[i][j]) {
                    flag[i][j] = true;  // true - previously visited
                    if (find(board, word, flag, 1, i, j)) {
                        return true;
                    }
                    //backtrack
                    flag[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, String word, boolean[][] flag, int index, int i, int j) {
        // index - to keep track of length of string
        if (index == word.length()) {
            return true;
        }

        boolean u = false, d = false, r = false, l = false;
        // UP
        if (i > 0 && (!flag[i - 1][j] && word.charAt(index) == board[i - 1][j])) {
            flag[i - 1][j] = true;

            u = find(board, word, flag, index + 1, i - 1, j);
            flag[i - 1][j] = false;
        }

        // RIGHT
        if (j < board[0].length - 1 && (!flag[i][j + 1] && word.charAt(index) == board[i][j + 1])) {
            flag[i][j + 1] = true;

            r = find(board, word, flag, index + 1, i, j + 1);
            flag[i][j + 1] = false;
        }

        // DOWN
        if (i < board.length - 1 && (!flag[i + 1][j] && word.charAt(index) == board[i + 1][j])) {
            flag[i + 1][j] = true;

            d = find(board, word, flag, index + 1, i + 1, j);
            flag[i + 1][j] = false;
        }

        // LEFT
        if (j > 0 && (!flag[i][j - 1] && word.charAt(index) == board[i][j - 1])) {
            flag[i][j - 1] = true;

            l = find(board, word, flag, index + 1, i, j - 1);
            flag[i][j - 1] = false;
        }

        return (u || r || d || l);
    }
}