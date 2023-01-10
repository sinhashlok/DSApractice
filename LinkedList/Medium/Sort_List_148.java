// https://leetcode.com/problems/sort-list/

package DSApractice.LinkedList.Medium;

public class Sort_List_148 {
    public static void main(String[] args) {
        ListNode four = new ListNode(0);
        ListNode three = new ListNode(4, four);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(5, two);
        ListNode head = new ListNode(-1, one);

        head = sortListTopMerge(head);
    }


        // merge sort - Top down merge Sort (RECURSIVE)
    static ListNode sortListTopMerge(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortListTopMerge(head); // left start from head
        ListNode right = sortListTopMerge(mid); // right start from mid

        return mergeTwoLists(left, right);  // will merge the two lists
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;

        ListNode temp = new ListNode();
        ListNode node = temp;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next;
        }

        node.next = (list1 != null) ? list1 : list2;

        return temp.next;
    }

    static ListNode getMid(ListNode head) {
        ListNode midPrev = null;

        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;  // moves at twice speed
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;

        return mid;
    }


    // merge sort - Bottom up merge Sort (ITERATIVE)
    static ListNode tail = new ListNode();
    static ListNode nextSubList = new ListNode();

    static ListNode sortListBottomMerge(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    static ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;

        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            if (midPrev.next  != null) {
                midPrev = midPrev.next;
            }
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;nextSubList = end.next;
        end.next = null;
        // return the start of second linked list
        return mid;
    }

    static void merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1.next = list1;
                newTail = newTail.next;
            }
            else {
                newTail.next = list2;
                list2.next = list2;
                newTail = newTail.next;
            }
        }

        newTail.next = (list1 != null) ? list1 : list2;

        // traverse till the end of the merge list to get the newTail
        while (newTail.next != null) {
            newTail = newTail.next;
        }

        // link the old tail with the head of merged list
        newTail.next = dummyHead.next;

        // update the old tail to the new tail of merge list
        tail = newTail;
    }

    static int getCount(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }
}