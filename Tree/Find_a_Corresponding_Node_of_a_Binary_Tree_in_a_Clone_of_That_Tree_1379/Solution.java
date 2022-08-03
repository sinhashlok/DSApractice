package DSApractice.Tree.Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree_1379;

public class Solution {

    TreeNode ans, target;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }

    public void inorder(TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o == target) {
                ans = c;
            }
            inorder(o.right, c.right);
        }
    }
}