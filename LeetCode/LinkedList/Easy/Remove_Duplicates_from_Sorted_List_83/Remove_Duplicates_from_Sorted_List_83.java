package DSApractice.LeetCode.LinkedList.Easy.Remove_Duplicates_from_Sorted_List_83;

public class Remove_Duplicates_from_Sorted_List_83 {
    // SOLUTION - ITERATIVE
    public ListNode deleteDuplicatesITER(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }

        return head;
    }


    // SOLUTION - RECURSIVE
    public ListNode deleteDuplicatesREC(ListNode head) {
        if (head == null) {
            return head;
        }
        remove(head, head);

        return head;
    }

    public void remove(ListNode node, ListNode prev){
        if (node.next != null) {
            if (node.next.val == node.val) {
                remove(node.next, prev);
            }
            else {
                prev.next = node.next;
                remove(node.next, prev.next);
            }
        }
        else {
            if (prev.val == node.val) {
                prev.next = null;
            }
            else {
                prev.next = node;
            }
        }
    }
}