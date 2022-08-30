package DSApractice.LinkedList.Medium;

import java.util.ArrayList;
import java.util.List;

public class Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points_2058 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next.next == null && head.next.next.next == null) {
            return new int[] {-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode after = curr.next;
        int index = 1;
        int first = -1, last = -1, res = Integer.MAX_VALUE;

        while (after != null) {
            if ((curr.val > prev.val && curr.val > after.val) || (curr.val < prev.val && curr.val < after.val)) {
                if (first == -1) {
                    first = index;
                } else {
                    res = Math.min(res, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = after;
            after = after.next;
            index++;
        }

        if (first == -1 || first == last) {
            return new int[] {-1, -1};
        }

        return new int[] {res, last - first};
    }
}