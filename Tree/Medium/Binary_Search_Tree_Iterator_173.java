package DSApractice.Tree.Medium;

import java.util.ArrayList;

public class Binary_Search_Tree_Iterator_173 {

    ArrayList<Integer> tree;
    int l = 0;
    public void BSTIterator(TreeNode root) {
        tree = new ArrayList<>();
        inorder(root);
    }

    public int next() {
        return tree.get(l++);
    }

    public boolean hasNext() {
        return l < tree.size();
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            tree.add(root.val);
            inorder(root.right);
        }
    }
}