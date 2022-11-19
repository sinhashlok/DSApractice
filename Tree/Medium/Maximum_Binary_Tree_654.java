package DSApractice.Tree.Medium;

public class Maximum_Binary_Tree_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    private int find(int[] nums, int l, int r){
        int maxInd = r;
        for (int i = l; i < r; i++) {
            if (nums[maxInd] < nums[i]) {
                maxInd = i;
            }
        }

        return maxInd;
    }

    private TreeNode construct(int[] nums, int l, int r){
        if (r < l) {
            return null;
        }

        int maxInd = find(nums, l, r);
        TreeNode root = new TreeNode(nums[maxInd]);
        root.left = construct(nums, l, maxInd-1);
        root.right = construct(nums, maxInd+1, r);

        return root;
    }
}