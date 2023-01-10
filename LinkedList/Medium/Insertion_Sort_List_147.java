package DSApractice.LinkedList.Medium;

import javax.management.MBeanRegistration;

public class Insertion_Sort_List_147 {

    public ListNode insertionSortList(ListNode head) {
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