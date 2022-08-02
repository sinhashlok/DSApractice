// https://leetcode.com/problems/palindrome-linked-list/

package DSApractice.LinkedList.Easy.Palindrome_Linked_List_234;

public class Palindrome_Linked_List_234 {

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);
        ListNode reverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }

            head = head.next;
            headSecond = headSecond.next;
        }
        reverse(reverseHead);

        return head == null || headSecond == null;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}