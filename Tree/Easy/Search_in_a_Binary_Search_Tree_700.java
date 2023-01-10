package DSApractice.Tree.Easy;

public class Search_in_a_Binary_Search_Tree_700 {

    // Recursive
    public TreeNode searchBSTRec(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }

        // Since it is BST, smaller elements will be on left
        return val < root.val? searchBSTRec(root.left, val): searchBSTRec(root.right, val);
    }

    // Iterative
    public TreeNode searchBSTIter(TreeNode root, int val) {
        while(root != null && root.val != val) {
            root = val<root.val? root.left:root.right;
        }
        return root;
    }
}