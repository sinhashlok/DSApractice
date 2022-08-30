package DSApractice.LinkedList.Medium;

public class Split_Linked_List_in_Parts_725 {
    public static void main(String[] args) {
        ListNode nine = new ListNode(10);
        ListNode eight = new ListNode(9, nine);
        ListNode seven = new ListNode(8, eight);
        ListNode six = new ListNode(7, seven);
        ListNode five = new ListNode(6, six);
        ListNode four = new ListNode(5, five);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(2, two);
        ListNode head = new ListNode(1, one);

        ListNode[] arr = splitListToParts(head, 3);
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }

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