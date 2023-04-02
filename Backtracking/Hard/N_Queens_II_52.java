package DSApractice.Backtracking.Hard;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_II_52 {

    private int count = 0;
    public int totalNQueens(int n) {
        List<List<Boolean>> board = new ArrayList<>();
        // add new row to board
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
            // to each row add 0
            for (int j = 0; j < n; j++) {
                board.get(i).add(false);
            }
        }

        for (int i = 0; i < n; i++) {
            // set the ith index in first row as 1 - Q
            board.get(0).set(i, true);
            helper(board, 1, n);
            // backtrack
            board.get(0).set(i, false);
        }

        return count;
    }

    private void helper(List<List<Boolean>> board, int x, int n) {
        if (x == board.size()) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkUp(board, x, i) && checkLeftD(board, x, i) && checkRightD(board, x, i)) {
                board.get(x).set(i, true);
                helper(board, x + 1, n);
                board.get(x).set(i, false);
            }
        }
    }

    private boolean checkUp(List<List<Boolean>> board, int i, int j) {
        while (i >= 0) {
            if (board.get(i).get(j)) {
                return false;
            }
            i--;
        }

        return true;
    }

    private boolean checkLeftD(List<List<Boolean>> board, int i, int j) {
        while (i >= 0 && j >= 0) {
            if (board.get(i).get(j)) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    private boolean checkRightD(List<List<Boolean>> board, int i, int j) {
        while (i >= 0 && j < board.size()) {
            if (board.get(i).get(j)) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}