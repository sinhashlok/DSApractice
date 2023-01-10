package DSApractice.Tree.Easy;


public class Merge_Two_Binary_Trees_617 {

    public TreeNode mergeTreesRec(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTreesRec(root1.left, root2.left);
        root1.right = mergeTreesRec(root1.right, root2.right);
        return root1;
    }
}