package DSApractice.Tree.Easy;

import DSApractice.Tree.Easy.TreeNode;

public class Solution {

    DSApractice.Tree.Easy.TreeNode ans, target;

    public final DSApractice.Tree.Easy.TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }

    public void inorder(DSApractice.Tree.Easy.TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o == target) {
                ans = c;
            }
            inorder(o.right, c.right);
        }
    }
}