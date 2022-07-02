/* https://leetcode.com/problems/combination-sum/

    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
*/

package DSApractice.LeetCode.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> list = combinationSum(arr, target);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] candidates, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(list, tempList,candidates, remain - candidates[i], i); // not i + 1, because we can reuse the element
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
