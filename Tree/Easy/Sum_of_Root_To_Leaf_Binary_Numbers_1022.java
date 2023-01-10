package DSApractice.Tree.Easy;

public class Sum_of_Root_To_Leaf_Binary_Numbers_1022 {
    int rootToLeaf = 0;
    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
    public void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = (currNumber << 1) | r.val;

            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }

            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }
}