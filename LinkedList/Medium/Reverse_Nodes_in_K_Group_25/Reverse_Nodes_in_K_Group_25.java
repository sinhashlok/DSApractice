package DSApractice.LinkedList.Medium.Reverse_Nodes_in_K_Group_25;

public class Reverse_Nodes_in_K_Group_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (true) {
            ListNode last = prev;
            ListNode newEnd = current;

            ListNode temp = current;
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    return head;
                }

                temp = temp.next;
            }

            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = current;

            if (current == null) {
                break;
            }

            prev = newEnd;
        }

        return head;
    }
}
