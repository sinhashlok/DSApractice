package DSApractice.Tree.Easy;

public class Diameter_of_Binary_Tree_543 {

    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        inorder(root);
        return maxPath;
    }

    private int inorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = inorder(root.left);
        int right = inorder(root.right);

        maxPath = Math.max(maxPath, left + right);
        return Math.max(left, right) + 1;
    }
}