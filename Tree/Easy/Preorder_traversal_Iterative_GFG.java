package DSApractice.Tree.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder_traversal_Iterative_GFG {

    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(TreeNode root) {
        preorderIter(root);
        return list;
    }

    public void preorderIter(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || stack.size() > 0) {

            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            node = node.right;
        }
    }
}