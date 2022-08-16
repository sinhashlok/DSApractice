package DSApractice.LinkedList.Medium;

import java.util.Stack;

public class Add_Two_Numbers_II_445 {

    /*
    * here we use stack to get sum
    * We will use two stacks to store the digits from left to right
    * Then we will keep popping the two stacks and add it to get the result
    * */
    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode node = l1;
        while (node != null) {
            s1.push(node.val);
            node = node.next;
        }

        node = l2;
        while (node != null) {
            s2.push(node.val);
            node = node.next;
        }

        Stack<Integer> res = new Stack<>();
        int carry = 0;
        while(!s1.empty() && !s2.empty()) {
            int x = s1.peek() + s2.peek() + carry;
            carry = x >= 10 ? 1 : 0;

            res.push(x % 10);

            s1.pop();
            s2.pop();
        }

        while (!s1.empty()) {
            int x = s1.peek() + carry;
            carry = x >= 10 ? 1 : 0;

            res.push(x % 10);

            s1.pop();
        }
        if (carry != 0) {
            res.push(1);
            carry--;
        }


        while (!s2.empty()) {
            int x = s2.peek() + carry;
            carry = x >= 10 ? 1 : 0;

            res.push(x % 10);

            s2.pop();
        }

        ListNode head = new ListNode(0);
        node = head;
        while (!res.empty()) {
            ListNode temp = new ListNode(res.peek());
            node.next = temp;
            node = temp;

            res.pop();
        }

        return head.next;
    }


    /*
    * Here we use Add Tow Numbers 1 approach
    * We just reverse l1 and l2
    * Find Sum, store sum in head(new node)
    * Reverse head
    * return head
    * */
    public ListNode addTwoNumbersStackReverse(ListNode l1, ListNode l2) {
        l1 = reverseListIter(l1);
        l2 = reverseListIter(l2);

        int carry = 0;
        ListNode head = l1;
        ListNode tail = l1;

        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + carry;
            carry = x / 10;

            l1.val = x % 10;

            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int x = l1.val + carry;
            carry = x / 10;

            l1.val = x % 10;

            tail = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            int x = l2.val + carry;
            carry = x / 10;

            ListNode temp = new ListNode(x % 10, null);
            tail.next = temp;
            tail = temp;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode temp = new ListNode(carry, null);
            tail.next = temp;
        }

        head = reverseListIter(head);
        return head;
    }
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
}