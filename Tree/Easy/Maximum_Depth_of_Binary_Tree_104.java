package DSApractice.Tree.Easy;

public class Maximum_Depth_of_Binary_Tree_104 {

    public int maxDepth(TreeNode root) {
        return heightCalc(root);
    }

    public int heightCalc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightCalc(root.left), heightCalc(root.right)) + 1;
    }
}