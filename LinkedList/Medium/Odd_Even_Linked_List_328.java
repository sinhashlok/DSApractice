package DSApractice.LinkedList.Medium;

public class Odd_Even_Linked_List_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode temp = head.next;
        ListNode tempHead = temp;

        while (temp != null && temp.next != null) {
            curr.next = curr.next.next;
            temp.next = temp.next.next;

            curr = curr.next;
            temp = temp.next;
        }

        curr.next = tempHead;
        return head;
    }
}