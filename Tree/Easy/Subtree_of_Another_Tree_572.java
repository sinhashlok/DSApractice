package DSApractice.Tree.Easy;

public class Subtree_of_Another_Tree_572 {
    private boolean flag = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (flag) {
            return true;
        }

        if (root != null) {
            if (helper(root, subRoot)) {
                flag = true;
                return true;
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        return false;
    }

    private boolean helper(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return (helper(root.left, subRoot.left) && helper(root.right, subRoot.right));
        }

        return root == null && subRoot == null;
    }
}