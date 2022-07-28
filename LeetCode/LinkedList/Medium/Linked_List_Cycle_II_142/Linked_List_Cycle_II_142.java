// https://leetcode.com/problems/linked-list-cycle-ii/

package DSApractice.LeetCode.LinkedList.Medium.Linked_List_Cycle_II_142;

public class Linked_List_Cycle_II_142 {
    public static void main(String[] args) {
        ListNode five = new ListNode(6);
        ListNode four = new ListNode(5, five);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);
        five.next = three;

        ListNode node = detectCycle(head);
        System.out.print(node.val);
    }

    static ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                length = lengthCycle(slow);
                break;
            }
        }

        // find start node
        ListNode f = head, s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both, s & f, forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s;
    }

    static int lengthCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        int size = 0;

        while (fast != null && fast.next != null) { // first check if ctycle, use above approach
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Calculate length
                int length = 0;
                do {
                    slow = slow.next;
                    length ++;
                } while(slow != fast);

                return length;
            }
        }

        return -1;
    }
}