package DSApractice.Tree.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder_Traversal_Iterative_GFG {

    List<Integer> list = new ArrayList<>();
    public List<Integer> inorder(TreeNode root) {
        inorderIter(root);
        return list;
    }

    public void inorderIter(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || stack.size() > 0) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            list.add(node.val);
            node = node.right;
        }
    }
}