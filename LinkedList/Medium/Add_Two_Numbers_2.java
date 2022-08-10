package DSApractice.LinkedList.Medium;

import java.util.LinkedHashMap;

public class Add_Two_Numbers_2 {

    /*
    * Time complexity - O(max(l1, l2))
    * Aux - O(1) + 1 new ListNode at max
    *
    * We do not need to create a new array we use l1, to get the sum
    *
    * We add l1 and l2 and store the sum digit in l1
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode tail = l1;

        /*
        * We traverse both l1 & l2 till either is null
        * variables:
        *   x - add l1 and l2 + carry.
        *   carry - keep tracks of x / 10, if x is more than one digit place.
        *   put x % 10, only the ten's digit place in the l1.val.
        *   move l1 and l2 next.
        */
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + carry;
            carry = x / 10;

            l1.val = x % 10;

            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        // if l1 is larger we just use same x and carry
        while (l1 != null) {
            int x = l1.val + carry;
            carry = x / 10;

            l1.val = x % 10;

            tail = l1;
            l1 = l1.next;
        }

        // if l2 was larger, we would have to make a new ListNode to add the sum and carry to the l1 List
        while (l2 != null) {
            int x = l2.val + carry;
            carry = x / 10;

            ListNode temp = new ListNode(x % 10, null);
            tail.next = temp;
            tail = temp;
            l2 = l2.next;
        }

        // if carry is still not zero, create one new ListNode, and attach it to ListNode
        if (carry != 0) {
            ListNode temp = new ListNode(carry, null);
            tail.next = temp;
        }

        return head;
    }
}