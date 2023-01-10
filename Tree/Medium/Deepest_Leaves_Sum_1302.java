package DSApractice.Tree.Medium;

public class Deepest_Leaves_Sum_1302 {

    // we keep track of the maximum depth (maxLevel) we have already visited
    private int sum = 0, maxLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        inorder(root, 0);

        return sum;
    }

    private void inorder(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {  // leaf node
            if (maxLevel == level) {    // is maxLevel
                sum += root.val;
            } else if (maxLevel < level) {  // lower than maxLevel, new maxLevel
                sum = root.val;
                maxLevel = level;
            } else {    // above maxLevel
                return;
            }
        }

        inorder(root.left, level + 1);
        inorder(root.right, level + 1);
    }
}