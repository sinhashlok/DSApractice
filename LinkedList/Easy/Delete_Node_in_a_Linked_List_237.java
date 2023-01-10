// https://leetcode.com/problems/delete-node-in-a-linked-list/

package DSApractice.LinkedList.Easy;

public class Delete_Node_in_a_Linked_List_237 {

    public void deleteNode(ListNode node) {
        // Since we cannot get the previous node, so we can not delete the given node.
        // We can just copy the next node to the given node and delete the next one.
        node.val = node.next.val;
        node.next = node.next.next;
    }
}