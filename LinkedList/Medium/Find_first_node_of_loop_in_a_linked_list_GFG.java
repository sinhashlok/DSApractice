package DSApractice.LinkedList.Medium;

public class Find_first_node_of_loop_in_a_linked_list_GFG {

    /*
    * Method 1 - Floyd’s Cycle finding algorithm
    *   1. If a loop is found, initialize a slow pointer to head, let fast pointer be at its position.
    *   2. Move both slow and fast pointers one node at a time.
    *   3. The point at which they meet is the start of the loop.
    * */
    public ListNode detectLoopOne(ListNode head) {
        // If list is empty or has only one node without loop
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // if there is no loop
        if (slow != fast) {
            return null;
        }

        // If loop exists. Start slow from head and fast from meeting point.
        slow = head;
        // when they meet => that will be the starting of the loop
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /*
    * Method 2 - Temp node creation
    *   The next pointer of each node that is traversed is made to point to this temporary node.
    *   This way we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not.
    *   Every node is checked to see if the next is pointing to a temporary node or not.
    *   In the case of the first node of the loop, the second time we traverse it this condition
    *   will be true, hence we return that node.
    * */
    public ListNode detectLoopTwo(ListNode head) {
        // Create a temp node
        ListNode temp = new ListNode();
        while (head != null) {
            // This condition is for the case when there is no loop
            if (head.next == null) {
                return null;
            }

            // Check if next is already pointing to temp
            // this node is the node where loop starts
            if (head.next == temp) {
                break;
            }

            // Store the pointer to the next node in order to get to it in the next step
            ListNode nex = head.next;

            // Make next point to temp
            head.next = temp;

            // Get to the next node in the list
            head = nex;
        }

        return head;
    }

    /*
    * Method 3 - */
}