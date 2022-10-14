package DSApractice.LinkedList.Medium;

public class Delete_the_Middle_Node_of_a_Linked_List_2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow = slow.next;

        slow.val = slow.next.val;
        slow.next = slow.next.next;

        return head;
    }
}