// https://leetcode.com/problems/merge-sorted-array/

package DSApractice.Sorting.Easy;

public class Merge_Sorted_Array_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // put elements form greater to smaller
        // the extra space at the end of nums1 is for that
        // we start form last, checking the larger element in both the arrays
        // and putting the larger one at the back

        int i = m - 1, j = n - 1, index = m + n - 1;
        // i -> nums1 last element, non zeros
        // j -> nums2 last element
        // index -> last index of the entire arrays

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}