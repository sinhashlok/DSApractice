package DSApractice.LinkedList.Medium;

public class Split_Linked_List_in_Parts_725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);

        if (size <= k) {
            ListNode[] list = new ListNode[k];
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    list[i] = null;
                } else {
                    ListNode temp = head;
                    head = head.next;

                    temp.next = null;
                    list[i] = temp;
                }
            }

            return list;
        }

        int rem = size % k;
        int split = size / k;

        ListNode[] list = new ListNode[k];
        int index = 0;
        while (k != 0) {
            int x = 1;
            ListNode temp = head;
            list[index++] = temp;

            while (x != split) {
                temp = temp.next;
                head = head.next;
                x++;
            }
            if (rem != 0) {
                temp = temp.next;
                head = head.next;
                rem--;
            }

            head = head.next;
            temp.next = null;

            k--;
        }

        return list;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}