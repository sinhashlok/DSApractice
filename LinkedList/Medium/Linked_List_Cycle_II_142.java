// https://leetcode.com/problems/linked-list-cycle-ii/

package DSApractice.LinkedList.Medium;

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

    // Floyd's Tortoise and Hare (Cycle Detection) - Linked List II
    /*
     * Each new element in the sequence is an element in nums at the index of the previous element.
     * If one starts from x = nums[0], such a sequence will produce a linked list with a cycle.
     *
     *
     * Algo:
     * In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise].
     * Since the hare goes fast, it would be the first to enter the cycle and run around the cycle. At some point,
     * the tortoise enters the cycle as well, and since it's moving slower the hare catches up to the
     * tortoise at some intersection point.
     * Now phase 1 is over, and the tortoise has lost.
     * ### Note that the intersection point is not the cycle entrance in the general case.
     *
     * To compute the intersection point, let's note that the hare has traversed twice as many nodes as the tortoise, i.e.
     * ### 2d(tortoise) = d(hare)
     *
     * In phase 2, we give the tortoise a second chance by slowing down the hare, so that it now moves at the
     * speed of tortoise: tortoise = nums[tortoise], hare = nums[hare].
     * The tortoise is back at the starting position, and the hare starts from the intersection point.
     *
     * Let's show that this time they meet at the cycle entrance after F steps.
     *   The tortoise started at zero, so its position after F steps is F.
     *   The hare started at the intersection point F+a=nC, so its position after F steps is nC+F, that is the same point as F.
     *   So the tortoise and the (slowed down) hare will meet at the entrance of the cycle.
     */
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