package DSApractice.LinkedList.Medium;


public class Reorder_List_143 {

    // Recursive
    private static ListNode pHead;
    public static void reorderListRecu(ListNode head) {
        if (head.next == null) {
            return;
        }
        pHead = head;

        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        recursive(s);
        if (pHead.next == pHead) {
            pHead.next = null;
        }
    }

    private static void recursive(ListNode node) {
        if (node == null) {
            // will return, and we will have the access to last node in previous recursion call stack
            return;
        }

        recursive(node.next);

        if (node.next == pHead.next) {
            node.next = null;
            return;
        }
        node.next = pHead.next;
        pHead.next = node;
        pHead = node.next;
    }

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reverse(mid);
        ListNode hf = head;

        // rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}