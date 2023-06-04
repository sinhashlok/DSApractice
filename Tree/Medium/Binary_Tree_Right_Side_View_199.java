package DSApractice.Tree.Medium;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Right_Side_View_199 {

    // we will use a maxLevel to keep track of visited levels
    // we will do reverse inorder (left - parent - right)
    private int maxLevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);

        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root != null) {
            if (level > maxLevel) {
                maxLevel = level;
                res.add(root.val);
            }

            helper(root.right, res, level + 1);
            helper(root.left, res, level + 1);
        }
    }
}