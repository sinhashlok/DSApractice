package DSApractice.LinkedList.Medium;

public class Reverse_Nodes_in_Even_Length_Groups_2074 {

        public ListNode reverseEvenLengthGroups(ListNode head) {
        int index = 1;

        ListNode node = head;
        ListNode prevG = null;
        while (node != null) {
            int size = 0;
            int i = index;

            ListNode count = node;
            while (count != null && i != 0 ) {
                count = count.next;
                size++;
                i--;
            }

            i = index;
            if (size % 2 == 0) {
                ListNode prev = node;
                ListNode tail = node.next;
                ListNode temp = null;
                i--;

                while (tail != null && i != 0) {
                    if (tail.next != null) {
                        temp = tail.next;
                    }

                    tail.next = prev;
                    prev = tail;
                    tail = temp;

                    temp = null;
                    i--;
                }

                prevG.next = prev;
                node.next = tail;
                prevG = node;
                node = tail;
            } else {
                while (node != null && i != 0) {
                    prevG = node;
                    node = node.next;
                    i--;
                }
            }

            index++;
        }

        return head;
    }
}