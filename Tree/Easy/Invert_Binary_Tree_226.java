package DSApractice.Tree.Easy;

public class Invert_Binary_Tree_226 {

    /*
    * we swap the left child and right child of each parent node recursively
    * by doing this we swap each node
    * */
    public TreeNode invertTree(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if ((root != null) && (root.left != null || root.right != null)) {
            TreeNode r = root.right;
            root.right = root.left;
            root.left = r;

            inorder(root.left);
            inorder(root.right);
        }
    }
}