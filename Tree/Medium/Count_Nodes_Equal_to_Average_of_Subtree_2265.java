package DSApractice.Tree.Medium;

public class Count_Nodes_Equal_to_Average_of_Subtree_2265 {

    // credits - https://leetcode.com/here-comes-the-g/
    public int averageOfSubtree(TreeNode root) {
        return inorder(root)[2];
    }

    private int[] inorder(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 0};
        }

        int[] left = inorder(root.left);
        int[] right = inorder(root.right);

        int total = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];
        int avg = total / count;

        int res = left[2] + right[2];

        if (avg == root.val) {
            res++;
        }

        return new int[] {total, count, res};
    }
}