// https://leetcode.com/problems/middle-of-the-linked-list/

package DSApractice.LinkedList.Easy.Middle_of_the_Linked_List_876;

public class Middle_of_the_Linked_List_876 {

    // LeetCode
    public ListNode middleNodeLeet(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

        // My Approach
    public ListNode middleNodeMY(ListNode head) {
         ListNode node = head;
         int size = 0;

         while (node != null) { // first get the size
             node = node.next;
             size ++;
         }

         size /= 2;

         while (size != 0) {    // iterate to the size index
             head = head.next;
             size --;
         }

         return head;
    }
}