package DSApractice.Recursion.Medium;

public class Word_Search_79 {
    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };

        char[][] board = {
                {'a','b'},
                {'c', 'd'}
        };

        System.out.println(exist(board, "dbac"));
    }

    static boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (word.charAt(0) == board[i][j]) {
                    flag[i][j] = true;
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

    static boolean find(char[][] board, String word, boolean[][] flag, int index, int i, int j) {
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