package DSApractice.Tree.Easy;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal_94 {
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);

        return list;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}