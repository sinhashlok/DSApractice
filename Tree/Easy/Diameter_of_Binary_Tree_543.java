package DSApractice.Tree.Easy;

public class Diameter_of_Binary_Tree_543 {

    private int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        inorder(root);
        return maxDia;
    }

    private int inorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = inorder(root.left);
        int r = inorder(root.right);

        maxDia = Math.max(maxDia, l + r);
        return Math.max(l, r) + 1;
    }
}