package DSApractice.Tree.Easy;

import GFG.BST.Node;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode dummy = new TreeNode(-1);
        dummy.right = helper(nums, 0, nums.length - 1);
        return dummy.right;
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[m]);

        node.left = helper(nums, l, m - 1);
        node.right = helper(nums, m + 1, r);

        return node;
    }
}