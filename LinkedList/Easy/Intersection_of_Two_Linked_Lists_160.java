// https://leetcode.com/problems/intersection-of-two-linked-lists/

package DSApractice.LinkedList.Easy;

public class Intersection_of_Two_Linked_Lists_160 {

    // credits - https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    public ListNode getIntersectionNodeLeet(ListNode headA, ListNode headB) {
        /*
        * We can use two iterations to do that. In the first iteration, we will reset the pointer of one linked list to
        * the head of another linked list after it reaches the tail node.
        *
        * In the second iteration, we will move two pointers until they point to the same node.
        * Our operations in first iteration will help us counteract the difference.
        *
        * So if two linked list intersects, the meeting point in second iteration must be the intersection point.
        * If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be
        * the tail node of both lists, which is null
        *
        * checkout the first comment from the above link for more detailed explanation
        */
        if(headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linked list
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

        // My approach - difference
    public ListNode getIntersectionNodeMy(ListNode headA, ListNode headB) {
// TIME complexity === (O(n)) - as all loops run only once - this is fixed

        // we first find the size of A and B list
        // this will give us the size of A + C and B + C, given C is not null
        // now we find the difference of sizeA and sizeB : A+C - B+C == A - B = dif
        int sizeA = 0, sizeB = 0;

        ListNode node = headA;
        while (node != null) {
            node = node.next;
            sizeA ++;
        }
        node = headB;
        while (node != null) {
            node = node.next;
            sizeB ++;
        }

        // if the difference is
        //  : + -> A is bigger - we move headA next by dif times
        // : - -> same for B
        // : 0 node need to do any change
        int dif = sizeA - sizeB;
        if (dif > 0) {
            while (dif != 0 && headA != null) {
                headA = headA.next;
                dif --;
            }
        } else if (dif < 0 && headB != null) {
            while (dif != 0) {
                headB = headB.next;
                dif ++;
            }
        }

        // if either is null means list is not attached
        if (headA == null || headB == null) {
            return null;
        }

        // we try to travel A and B
        // if they intersect loop breaks
        while (headA != headB && (headA != null && headB != null)) {
            headA = headA.next;
            headB = headB.next;
        }

        if (headA == headB) {
            return headA;
        }

        return null;
    }
}