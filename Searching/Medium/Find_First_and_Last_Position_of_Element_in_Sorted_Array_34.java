// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package DSApractice.LeetCode.Searching.Medium;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {

    public int[] searchRange(int[] nums, int target) {
        return new int[] {firstOccurrence(nums, target), lastOccurrence(nums, target)};
    }
    static int firstOccurrence(int[] arr, int k) {
        int n = arr.length;
        int l = 0, h = n - 1, m = 0;

        while (l <= h) {
            m = l + (h - l) / 2;

            if (arr[m] < k) {
                l = m + 1;
            }
            else if (arr[m] > k) {
                h = m - 1;
            }
            else {
                if (m == 0 || arr[m-1] != arr[m]) {  // if m is either the first element or the prev element is not same
                    return m;
                }
                else {
                    h = m - 1;
                }
            }
        }

        return -1;
    }
    static int lastOccurrence(int[] arr, int k) {
        int n = arr.length;
        int l = 0, h = n - 1, m = 0;

        while(l <= h) {
            m = (l + h) / 2;

            if(k > arr[m]) {
                l = m + 1;
            }
            else if(k < arr[m]) {
                h = m - 1;
            }
            else {
                if(m == n - 1 || arr[m + 1] != arr[m]) {
                    return m;
                }
                else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }
}