package DSApractice.Tree.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path_Sum_II_113 {

    List<List<Integer>> list = new ArrayList<>();   // answer list
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return list;
        }

        List<Integer> temp = new ArrayList<>(); // will store the current paths
        helper(root, targetSum, temp);
        return list;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> temp) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;  // subtract current root val
        temp.add(root.val); // add that root val in temp
        if (targetSum == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(temp));    // add temp as new List in list (answer list)
        }

        helper(root.left, targetSum, temp);
        helper(root.right, targetSum, temp);

        // backtrack
        targetSum += root.val;
        temp.remove(temp.size() - 1);
    }
}