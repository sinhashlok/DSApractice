package DSApractice.Tree.Medium;

public class Count_Complete_Tree_Nodes_222 {
    int num = 0;
    boolean flag = true;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return 1;
        }

        int h = getHeight(root);
        int count = (int)Math.pow(2,h - 1) - 1;
        inorder(root, h, 1);

        count += num;
        return count;
    }

    private int getHeight(TreeNode root) {
        if (root.left == null) {
            return 1;
        }

        return getHeight(root.left) + 1;
    }

    private void inorder(TreeNode root, int h, int level) {
        if (!flag) {
            return;
        }

        if (root == null) {
            flag = false;
            return;
        }

        if (level == h) {
            num++;
            return;
        }

        inorder(root.left, h, level + 1);
        inorder(root.right, h, level + 1);
    }
}