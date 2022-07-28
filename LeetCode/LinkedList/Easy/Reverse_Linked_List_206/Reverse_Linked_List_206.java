// https://leetcode.com/problems/reverse-linked-list/

package DSApractice.LeetCode.LinkedList.Easy.Reverse_Linked_List_206;

import java.util.List;

public class Reverse_Linked_List_206 {
    public static void main(String[] args) {
        ListNode four = new ListNode(5);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);

        head = reverseList(head);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    static ListNode reverseList(ListNode head) {
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