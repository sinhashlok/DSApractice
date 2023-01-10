package DSApractice.Tree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                queue.add(null);

                list.add(new ArrayList<>(tempList));
                tempList.clear();
                continue;
            }

            tempList.add(temp.val);

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        list.add(new ArrayList<>(tempList));
        return list;
    }
}