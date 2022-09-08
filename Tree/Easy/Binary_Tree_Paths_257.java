package DSApractice.Tree.Easy;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        inorder(root, list, new StringBuilder());

        return list;
    }

    private void inorder(TreeNode root, List<String> list, StringBuilder str) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            StringBuilder s = new StringBuilder(str);
            str.append(root.val);

            list.add(str.toString());
            str.setLength(str.length() - String.valueOf(root.val).length());
            return;
        }

        str.append(root.val).append("->");
        inorder(root.left, list, str);
        inorder(root.right, list, str);
        int n = String.valueOf(root.val).length() + 2;
        str.setLength(str.length() - n);
    }
}