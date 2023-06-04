package DSApractice.Backtracking.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        Arrays.sort(nums);

        helper(nums, ans, subsets, 0);
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> s, int index) {
        ans.add(new ArrayList<>(s));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            s.add(nums[i]);
            helper(nums, ans, s, i + 1);
            s.remove(Integer.valueOf(nums[i]));
        }
    }
}