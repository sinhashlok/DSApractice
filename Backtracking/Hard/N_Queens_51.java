// https://leetcode.com/problems/n-queens/
package DSApractice.Backtracking.Hard;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<Boolean>> board = new ArrayList<>();
        // add new row to board
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
            // to each row add 0
            for (int j = 0; j < n; j++) {
                board.get(i).add(false);
            }
        }

        List<List<String>> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // set the ith index in first row as 1 - Q
            board.get(0).set(i, true);
            helper(answers, board, 1, n);
            // backtrack
            board.get(0).set(i, false);
        }

        return answers;
    }

    private void helper(List<List<String >> ans, List<List<Boolean>> board, int x, int n) {
        if (x == board.size()) {
            addItem(ans, board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkUp(board, x, i) && checkLeftD(board, x, i) && checkRightD(board, x, i)) {
                board.get(x).set(i, true);
                helper(ans, board, x + 1, n);
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


    private void addItem(List<List<String >> ans, List<List<Boolean>> board) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < board.size(); j++) {
                if (board.get(i).get(j)) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            str.add(String.valueOf(s));
        }

        ans.add(new ArrayList<>(str));
    }
}