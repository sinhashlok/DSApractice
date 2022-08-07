package DSApractice.LinkedList.Medium;

public class Remove_Nth_Node_From_End_of_List_19 {
    // we use fast and slow pointer kind of approach
    // we move fast n places ahead of slow
    // so when fast becomes null
    // slow will be n positions behind null or at the target node

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // now skip the current slow node
        slow.next = slow.next.next;
        return start.next;
    }
}