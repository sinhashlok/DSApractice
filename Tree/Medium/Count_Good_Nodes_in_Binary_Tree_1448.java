package DSApractice.Tree.Medium;

public class Count_Good_Nodes_in_Binary_Tree_1448 {

    private int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);

        return count;
    }

    private void helper(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) {
                count++;
            }

            // we update max value while calling the helper function
            // so that we do not have to manually backtrack
            // and change max value while going from left subtree to right.
            helper(root.left, Math.max(max, root.val));
            helper(root.right, Math.max(max, root.val));
        }
    }
}