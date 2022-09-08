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
        if(root == null) {
            return;
        }

        int n = str.length();
        str.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(str.toString());
        } else {
            str.append("->");

            inorder(root.left, list, str);
            inorder(root.right, list, str);
        }

        str.setLength(n);
    }
}