package DSApractice.Tree.Easy;

public class Balanced_Binary_Tree_110 {

    boolean flag = true;
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

        int left = inorder(root.left);
        int right = inorder(root.right);

        if (Math.abs(left - right) > 1) {
            flag = false;
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}