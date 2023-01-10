package DSApractice.LinkedList.Medium;

import java.util.LinkedHashMap;

public class Add_Two_Numbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;

        int sum = 0;
        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;

            head.next = new ListNode();
            head = head.next;
            head.val = sum % 10;
            sum /= 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode temp = null;
        if (l1 != null) {
            temp = l1;
        } else {
            temp = l2;
        }

        while (temp != null) {
            sum += temp.val;

            head.next = new ListNode();
            head = head.next;
            head.val = sum % 10;
            sum /= 10;

            temp = temp.next;
        }
        if (sum != 0) {
            head.next = new ListNode();
            head = head.next;
            head.val = sum % 10;
        }

        return res.next;
    }
}