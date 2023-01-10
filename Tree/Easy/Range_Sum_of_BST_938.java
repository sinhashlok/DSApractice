package DSApractice.Tree.Easy;

public class Range_Sum_of_BST_938 {

        // Discussion
    // credit: https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
    public int rangeSumBST(TreeNode root, int low, int right) {
        // base case.
        if (root == null) {
            return 0;
        }
        // left branch excluded.
        if (root.val < low) {
            return rangeSumBST(root.right, low, right);
        }
        // right branch excluded.
        if (root.val > right) {
            return rangeSumBST(root.left, low, right);
        }
        // count in both children.
        return root.val + rangeSumBST(root.right, low, right) + rangeSumBST(root.left, low, right);
    }

        // My Approach
    public int rangeSumBSTMY(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBSTMY(root.left, low, high) + rangeSumBSTMY(root.right, low, high);
        }

        return rangeSumBSTMY(root.left, low, high) + rangeSumBSTMY(root.right, low, high);
    }
}