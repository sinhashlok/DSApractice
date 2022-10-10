package DSApractice.Tree.Medium;

public class Sum_of_Nodes_with_Even_Valued_Grandparent_1315 {

    private int count = 0;
    public int sumEvenGrandparent(TreeNode root) {
        preOrder(root);
        return count;
    }

    private void preOrder(TreeNode root) {
        if (root != null) {

            if (root.val % 2 == 0) {
                sum(root);
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void sum(TreeNode root) {
        if (root.left != null) {
            count += (root.left.left != null ? root.left.left.val : 0);
            count += (root.left.right != null ? root.left.right.val : 0);
        }
        if (root.right != null) {
            count += (root.right.left != null ? root.right.left.val : 0);
            count += (root.right.right != null ? root.right.right.val : 0);
        }
    }
}