package DSApractice.LeetCode.LinkedList.Medium.Reverse_Linked_List_II_92;

public class Reverse_Linked_List_II_92 {
    public static void main(String[] args) {
        ListNode four = new ListNode(5);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);

//        head = reverseBetween(head, 2, 4);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

//    static ListNode reverseBetween(ListNode head, int left, int right) {
//
//    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = head.next;

        while (next != null) {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }

        head.next = prev;

        return head;
    }
}