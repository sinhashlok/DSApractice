package DSApractice.LinkedList.Medium;

public class Rotate_List_61 {

    // LeetCode discussion
    public ListNode rotateRight(ListNode head, int k) {
        // credit: https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // find size of list
        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }

        for (int j = i - (k % i); j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    // My approach
    public ListNode rotateRightMy(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int size = findSize(head);
        k %= size;

        if (k == 0 || size == 1) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode node = slow.next;

        fast.next = head;
        slow.next = null;
        head = node;

        return head;
    }

    public int findSize(ListNode head) {
        ListNode node = head;
        int size = 0;

        while (node != null) {
            size ++;
            node = node.next;
        }

        return size;
    }
}