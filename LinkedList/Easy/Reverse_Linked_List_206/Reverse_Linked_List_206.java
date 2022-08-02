// https://leetcode.com/problems/reverse-linked-list/

package DSApractice.LinkedList.Easy.Reverse_Linked_List_206;

public class Reverse_Linked_List_206 {
    public static void main(String[] args) {
        ListNode four = new ListNode(5);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);

        head = reverseListIter(head);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    // Iterative approach
    static ListNode reverseListIter(ListNode head) {
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
    static ListNode reverseListRev(ListNode head) {
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
    static ListNode reverseRec(ListNode curr, ListNode prev, ListNode newHead, ListNode head) {
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