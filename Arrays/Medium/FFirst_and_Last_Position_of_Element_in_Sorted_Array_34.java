// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package DSApractice.Arrays.Medium;

public class FFirst_and_Last_Position_of_Element_in_Sorted_Array_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = first(nums, target);
        arr[1] = last(nums, target);

        return arr;
    }

    static int first(int[] arr, int target) {
        int l = 0, h = arr.length - 1, m = 0;

        while (l <= h) {
            m = l + (h - l) / 2;

            if (arr[m] == target) {
                if (m != 0 && arr[m] == arr[m-1])
                    h = m - 1;
                else
                    return m;
            }

            if (arr[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }

        return -1;
    }

    static int last(int[] arr, int k) {
        int l = 0, n = arr.length;
        int h = n-1;
        int mid;

        while (l <= h) {
            mid = l + (h - l) / 2;

            if (arr[mid] < k)
                l = mid + 1;
            else if (arr[mid] > k)
                h = mid - 1;
            else {
                if (mid == n-1 || arr[mid] != arr[mid+1])
                    return mid;
                else
                    l = mid + 1;
            }
        }

        return -1;
    }
}