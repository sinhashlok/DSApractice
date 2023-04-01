package DSApractice.Backtracking.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates, target, ans, res, 0);
        return res;
    }

    private void helper(int[] candidates, int x, List<Integer> ans, List<List<Integer>> res, int index) {
        if (x < 0) {
            return;
        }
        if (x == 0) {
            res.add(new ArrayList<>(ans));
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > x) {
                break;
            }

            ans.add(candidates[i]);
            helper(candidates, x - candidates[i], ans, res, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}