package DSApractice.Tree.Easy;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal_145 {

    List<Integer> list;
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        postorder(root);

        return list;
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
}