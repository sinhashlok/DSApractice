// https://leetcode.com/problems/reverse-linked-list/

package DSApractice.LinkedList.Easy;

public class Reverse_Linked_List_206 {

    // Iterative approach
    public ListNode reverseListIter(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = head.next;

        while (next != null) {
            head.next = prev;
            prev = head;
            head = next;
            if (next != null) {
                next = next.next;
            }
        }

        head.next = prev;

        return head;
    }


    // Recusrive approach
    public ListNode reverseListRev(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size += 1;
            node = node.next;

            if (size > 2) {
                break;
            }
        }

        if (size == 0 || size == 1) {
            return head;
        }
        else if (size == 2) {
            ListNode temp = head.next;
            head.next.next = head;
            head.next = null;

            return temp;
        }
        else {
            head = reverseRec(head.next, head, head, head);
        }

        return head;
    }
    private ListNode reverseRec(ListNode curr, ListNode prev, ListNode newHead, ListNode head) {
        if (curr.next == null) {
            curr.next = prev;
            newHead = curr;
            return newHead;
        }

        newHead = reverseRec(curr.next, curr, newHead, head);

        curr.next = prev;

        if (prev == head) {
            prev.next = null;
        }

        return newHead;
    }
}