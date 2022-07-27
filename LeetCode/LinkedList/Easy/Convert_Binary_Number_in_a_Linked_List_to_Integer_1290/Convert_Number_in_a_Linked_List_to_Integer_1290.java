// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

package DSApractice.LeetCode.LinkedList.Easy.Convert_Binary_Number_in_a_Linked_List_to_Integer_1290;

public class Convert_Number_in_a_Linked_List_to_Integer_1290 {
    public int getDecimalValue(ListNode head) {
         int num = head.val;
         while (head.next != null) {
             num = num * 2 + head.next.val;
             // num contains all the numbers * 2 before it,
             // so when we do num * 2 => (num1 * 2 + 1/ 0) * 2 + 1/0, and goes on
             head = head.next;
         }
         return num;
    }

    public int getDecimalValueBit(ListNode head) {
        int num = 0;
        while(head!=null) {
            num <<= 1;              // Left shift num by 1 position to make way for next bit
            num += head.val;        // Add next bit to num at least significant position
            head = head.next;
        }
        return num;
    }
}