package DSApractice.LinkedList.Easy;

public class Remove_Linked_List_Elements_203 {

    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsRec(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElementsIter(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while(head != null && head.val == val) {
            head = head.next;
        }

        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                continue;
            }
            if (node.next != null) {
                node = node.next;
            }
        }

        return head;
    }
}