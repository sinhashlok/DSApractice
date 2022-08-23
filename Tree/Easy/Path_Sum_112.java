package DSApractice.Tree.Easy;

public class Path_Sum_112 {

    // Leetcode - shortert solution, same speed
    public boolean hasPathSumLeet(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        helper(root, targetSum);
        return flag;
    }

    private void helper(TreeNode root, int targetSum) {
        if (flag) {
            return;
        }
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            flag = true;
            return;
        }

        helper(root.left, targetSum);
        helper(root.right, targetSum);
        targetSum += root.val;
    }
}