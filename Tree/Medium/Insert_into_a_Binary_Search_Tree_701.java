package DSApractice.Tree.Medium;

import GFG.BST.Node;

public class Insert_into_a_Binary_Search_Tree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode parent = null, temp = root;
        while (temp !=  null) {
            parent = temp;
            if (temp.val < val) {
                temp = temp.right;
            } else if (temp.val > val) {
                temp = temp.left;
            }
        }

        if (parent == null) {
            return new TreeNode(val);
        }

        if (parent.val < val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }

        return root;
    }
}