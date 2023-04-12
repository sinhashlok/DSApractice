package DSApractice.LinkedList.Medium;

public class Maximum_Twin_Sum_of_a_Linked_List_2130 {

    // here LinkedList breaks after n/2 node
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // mid node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse after mid node
        ListNode temp = null;
        ListNode prev = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // find max
        int max = 0;
        while (prev != null) {
            max = Math.max(max, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return max;
    }


    // My approach - LinkedList does not break
    public int pairSumMy(ListNode head) {
        ListNode prev = head;
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }

        prev.next = reverse(s);
        s = prev.next;

        int max = 0;

        while (s != null) {
            max = Math.max(max, head.val + s.val);
            head = head.next;
            s = s.next;
        }

        return max;
    }

    private ListNode reverse(ListNode s) {
        ListNode head = s;

        ListNode prev = null;
        ListNode curr = s;
        ListNode temp = s.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = temp;

            if (curr == null) {
                break;
            }
            temp = temp.next;
        }

        return prev;
    }
}