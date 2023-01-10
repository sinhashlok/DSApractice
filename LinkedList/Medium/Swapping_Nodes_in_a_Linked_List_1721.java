package DSApractice.LinkedList.Medium;

public class Swapping_Nodes_in_a_Linked_List_1721 {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode temp = fast;   // store node of kth from start

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        int data = temp.val;
        temp.val = slow.val;
        slow.val = data;

        return head;
    }
}