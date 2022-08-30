package DSApractice.LinkedList.Medium;

import java.util.ArrayList;
import java.util.List;

public class Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points_2058 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next.next == null) {
            return new int[] {-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int first = -1, last = -1, res = Integer.MAX_VALUE;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                if (first == -1) {
                    first = index;
                } else {
                    res = Math.min(res, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (first == -1 || first == last) {
            return new int[] {-1, -1};
        }

        return new int[] {res, last - first};
    }
}