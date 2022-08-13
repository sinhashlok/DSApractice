package DSApractice.LinkedList.Medium;

public class Remove_Duplicates_from_Sorted_List_II_82 {
    public ListNode deleteDuplicates(ListNode head) {
        // create a sentinel node
        ListNode sentinel = new ListNode(0, head);

        // predecessor = last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // skip all duplicates
                pred.next = head.next;
            } else { // otherwise, move predecessor
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }

        return sentinel.next;
    }
}