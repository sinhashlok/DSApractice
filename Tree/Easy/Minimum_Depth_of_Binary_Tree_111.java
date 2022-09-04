package DSApractice.Tree.Easy;

public class Minimum_Depth_of_Binary_Tree_111 {

    int minH = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getHeight(root, 1);
        return minH;
    }

    private void getHeight(TreeNode root, int h) {
        if (minH <= h) {
            return;
        }

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            minH = Math.min(h, minH);
            return;
        }

        getHeight(root.left, h + 1);
        getHeight(root.right, h + 1);
    }
}