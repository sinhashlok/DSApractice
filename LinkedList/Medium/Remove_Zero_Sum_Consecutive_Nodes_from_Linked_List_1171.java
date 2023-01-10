package DSApractice.LinkedList.Medium;

import java.util.HashMap;
import java.util.Map;

public class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List_1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode curr = sentinel;

        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();

        while (curr != null) {
            sum += curr.val;

            // sum is already present
            if (map.containsKey(sum)) {
                // make curr point to next of first time sum was found
                curr = map.get(sum).next;

                // p -> helps us in removing all the sums that we added after the first sum,
                // this is done because this node will be skipped as they give sum 0
                int p = sum + curr.val;
                // in-short we remove all nodes that gave prefix sum more than sum.
                while (p != sum) {
                    map.remove(p);
                    curr = curr.next;
                    p += curr.val;
                }
                map.get(sum).next = curr.next;
            } else {
                map.put(sum, curr);
            }

            curr = curr.next;
        }

        return sentinel.next;
    }

    public ListNode removeElements(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode sentinel = new ListNode(0, head);

        // to get prefix sum in map
        int sum = 0;
        for (ListNode p = sentinel; p != null; p = p.next) {
            sum += p.val;
            // here what happens is that we update the sum's Value (ListNode) with the rightmost node that
            // shows the same sum
            map.put(sum, p);
        }

        // now to reconnect the nodes
        sum = 0;
        for (ListNode p = sentinel; p != null; p = p.next) {
            sum += p.val;
            // now here we find the right most node that has the same sum
            // and reconnect the node to next of it
            p.next = map.get(sum).next;
        }

        return sentinel.next;
    }
}