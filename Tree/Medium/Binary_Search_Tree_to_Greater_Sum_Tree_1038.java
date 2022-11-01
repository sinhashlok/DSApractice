package DSApractice.Tree.Medium;

public class Binary_Search_Tree_to_Greater_Sum_Tree_1038 {

    private int up = 0; // in-short keeps track of max sum, when going up
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) {
            bstToGst(root.right);
        }

        root.val = up + root.val;
        up = root.val;

        if (root.left != null) {
            bstToGst(root.left);
        }

        return root;
    }
}