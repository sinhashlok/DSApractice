// https://leetcode.com/problems/peak-index-in-a-mountain-array/

package DSApractice.LeetCode.Searching.Medium;

public class Peak_Index_in_a_Mountain_Array_852 {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mi = l + (r - l) / 2;

            if (arr[mi] < arr[mi + 1]) {
                l = mi + 1;
            } else {
                r = mi;
            }
        }

        return l;
    }
}