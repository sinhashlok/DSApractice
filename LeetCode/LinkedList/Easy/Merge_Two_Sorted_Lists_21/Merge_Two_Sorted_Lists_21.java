// https://leetcode.com/problems/merge-two-sorted-lists/

package DSApractice.LeetCode.LinkedList.Easy.Merge_Two_Sorted_Lists_21;

public class Merge_Two_Sorted_Lists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
}