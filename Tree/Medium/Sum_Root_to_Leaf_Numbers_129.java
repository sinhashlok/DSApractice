package DSApractice.Tree.Medium;

import java.util.ArrayList;
import java.util.List;

public class Sum_Root_to_Leaf_Numbers_129 {

    int sum = 0;    // this will the final sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int x) {
        // x for sum of each root to leaf node
        if (root == null) {
            return;
        }

        x = (x * 10) + root.val;
        if (root.left == null && root.right == null) {
            sum += x;
        }

        helper(root.left, x);
        helper(root.right, x);

        // backtrack
        x /= 10;
    }
}