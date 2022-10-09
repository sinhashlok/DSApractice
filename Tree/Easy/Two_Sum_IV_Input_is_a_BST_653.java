package DSApractice.Tree.Easy;

import java.util.HashSet;

public class Two_Sum_IV_Input_is_a_BST_653 {

    /*
    * For each node, we check if k - node.val exists in this BST.
    */
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, root, k);
    }

    private boolean inorder(TreeNode root, TreeNode curr, int k) {
        if (curr == null) {
            return false;
        }

        return search(root, curr, k - curr.val) || inorder(root, curr.left, k) || inorder(root, curr.right, k);
    }

    private boolean search(TreeNode root, TreeNode curr, int target) {
        if (root == null) {
            return false;
        }

        return ((root.val == target) && (root != curr))
                || ((root.val < target) && search(root.right, curr, target))
                    || ((root.val > target) && search(root.left, curr, target));
    }
}