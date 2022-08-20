package DSApractice.LinkedList.Medium;

import javax.management.MBeanRegistration;

public class Insertion_Sort_List_147 {
    public static void main(String[] args) {
        ListNode four = new ListNode(0);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(5, two);
        ListNode head = new ListNode(-1, one);

//        ListNode three = new ListNode(3);
//        ListNode two = new ListNode(1, three);
//        ListNode one = new ListNode(2, two);
//        ListNode head = new ListNode(4, one);

        head = insertionSortList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static ListNode insertionSortList(ListNode head) {
        // pre-head, if a node is smaller than head
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode node = head, after = head.next;

        while (after != null) {
            if (node.val > after.val) {
                ListNode temp = sentinel;
                while (temp.next.val <= after.val) {
                    temp = temp.next;
                }

                node.next = after.next;
                after.next = temp.next;
                temp.next = after;

                node = sentinel.next;
                after = node.next;
            }

            node = node.next;
            after = after.next;
        }

        return sentinel.next;
    }
}