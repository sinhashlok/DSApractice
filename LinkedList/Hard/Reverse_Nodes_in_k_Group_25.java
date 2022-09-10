package DSApractice.LinkedList.Hard;

public class Reverse_Nodes_in_k_Group_25 {
    public static void main(String[] args) {
        ListNode four = new ListNode(5);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);

        head = reverseKGroup(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }

        ListNode sentinle = new ListNode(-1, head);
        ListNode PREV = sentinle, start = head, end = start;

        while (true) {
            // point END to correct node
            int move = k - 1;
            while (move != 0) {
                if (end == null) {
                    return sentinle.next;
                }

                end = end.next;
                move--;
            }
            if (end == null) {
                return sentinle.next;
            }

            // Reverse
            ListNode prev = start, curr = start.next, temp = null;
            while (prev != end) {
                temp = curr.next;

                curr.next = prev;

                prev = curr;
                curr = temp;
            }

            PREV.next = end;
            PREV = start;
            start.next = curr;
            start = curr;
            end = start;
        }
    }
}