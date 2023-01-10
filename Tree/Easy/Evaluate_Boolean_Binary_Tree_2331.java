package DSApractice.Tree.Easy;

import DSApractice.Tree.Easy.TreeNode;

public class Evaluate_Boolean_Binary_Tree_2331 {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val != 0;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val==2 ? left || right : left && right;
    }
}