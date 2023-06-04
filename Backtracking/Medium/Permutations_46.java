package DSApractice.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        helper(res, ans, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> ans, int[] nums) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
        }

        for (int i = 0; i < nums.length; i++) {
            // only add new element, if does not exists already
            if (!ans.contains(nums[i])) {
                ans.add(nums[i]);
                helper(res, ans, nums);

                // backtrack
                ans.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}