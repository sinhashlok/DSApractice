package DSApractice.LinkedList.Medium;

public class Swap_Nodes_in_Pairs_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel, curr = head, node = head.next;

        while (true) {
            curr.next = node.next;
            node.next = curr;
            prev.next = node;

            curr = node;
            node = curr.next;

            if (node.next != null && node.next.next != null) {
                prev = prev.next.next;
                curr = curr.next.next;
                node = node.next.next;
            } else {
                break;
            }
        }

        return sentinel.next;
    }
}
