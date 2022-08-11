package DSApractice.Tree.Easy;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class Increasing_Order_Search_Tree_897 {

    // Rearrange the tree nodes
    TreeNode cur;
    public TreeNode increasingBSTInline(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);

        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        node.left = null;
        cur.right = node;
        cur = node;

        inorder(node.right);
    }

    // create new Tree
    public TreeNode increasingBSTnewTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = new TreeNode(0), cur = ans;

        // make new tree
        for (int l : list) {
            cur.right = new TreeNode(l);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val); // add node value to list
        inorder(node.right, list);
    }
}