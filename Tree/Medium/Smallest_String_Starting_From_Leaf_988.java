package DSApractice.Tree.Medium;

public class Smallest_String_Starting_From_Leaf_988 {

    StringBuilder ans = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder str = new StringBuilder();
        helper(root, str);

        return ans.toString();
    }

    private void helper(TreeNode root, StringBuilder str) {
        if (root == null) {
            return;
        }

        str.append(String.valueOf((char) (root.val + 97)));
        if (root.left == null && root.right == null) {
            StringBuilder temp = new StringBuilder(str);
            temp.reverse();

            if (ans.isEmpty()) {
                ans.append(temp);
            } else {
                int compare = ans.toString().compareTo(temp.toString());
                if (compare > 0) {
                    ans.setLength(0);
                    ans.append(temp);
                }
            }
        }

        helper(root.left, str);
        helper(root.right, str);

        // backtrack
        str.setLength(str.length() - 1);
    }
}
