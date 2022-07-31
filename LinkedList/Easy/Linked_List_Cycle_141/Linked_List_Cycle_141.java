// https://leetcode.com/problems/linked-list-cycle/

package DSApractice.LeetCode.LinkedList.Easy.Linked_List_Cycle_141;

public class Linked_List_Cycle_141 {

        // check if cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


        // find length of cycle
        public int lengthCycle(ListNode head) {
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