package DSApractice.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        solution(0, candidates, target, list, new ArrayList<>());

        return list;
    }

    public void solution(int index, int[] arr, int target, List<List<Integer>> list, List<Integer> temp) {
        if(index == arr.length) {
            if(target == 0) {
                list.add(new ArrayList<>(temp));
            }

            return;
        }

        if(arr[index] <= target) {  // first use the same element again and again
            temp.add(arr[index]);
            solution(index, arr, target - arr[index], list, temp);
            // backtrack
            temp.remove(temp.size() - 1);
        }

        solution(index + 1, arr, target, list, temp);
    }
}