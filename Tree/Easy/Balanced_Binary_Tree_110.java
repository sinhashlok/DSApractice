package DSApractice.Tree.Easy;

public class Balanced_Binary_Tree_110 {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        inorder(root);
        return flag;
    }

    private int inorder(TreeNode root) {
        if (!flag) {
            return -1;
        }
        if (root == null) {
            return 0;
        }

        int l = inorder(root.left);
        int r = inorder(root.right);

        if (Math.abs(l - r) > 1) {
            flag = false;
            return -1;
        }

        return Math.max(l, r) + 1;
    }
}