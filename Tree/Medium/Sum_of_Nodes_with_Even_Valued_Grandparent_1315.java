package DSApractice.Tree.Medium;

public class Sum_of_Nodes_with_Even_Valued_Grandparent_1315 {

    // My Logic
    private int count = 0;
    public int sumEvenGrandparentMy(TreeNode root) {
        preOrder(root);
        return count;
    }

    private void preOrder(TreeNode root) {
        if (root != null) {

            if (root.val % 2 == 0) {
                sum(root);
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void sum(TreeNode root) {
        if (root.left != null) {
            count += (root.left.left != null ? root.left.left.val : 0);
            count += (root.left.right != null ? root.left.right.val : 0);
        }
        if (root.right != null) {
            count += (root.right.left != null ? root.right.left.val : 0);
            count += (root.right.right != null ? root.right.right.val : 0);
        }
    }



    // Another approach - we keep track of current, parent and grandparent TreeNode
    // regards - https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/477095/Easy-DFS-solution
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        inorder(root, null, null);
        return sum;
    }

    private void inorder(TreeNode current, TreeNode parent, TreeNode grandParent) {
        if (current != null) {
            if (grandParent != null && grandParent.val % 2 == 0) {
                sum += current.val;
            }

            inorder(current.left, current, parent);// ( newChild, parent, GrandParent)
            inorder(current.right, current, parent);
        }
    }
}