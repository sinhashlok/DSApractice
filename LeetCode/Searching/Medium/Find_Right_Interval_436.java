package DSApractice.LeetCode.Searching.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Find_Right_Interval_436 {

        // My Code
    /*
    * We keep a temp array -> put all start elements in it and sort it
    * Maps -> store the start elements and their index in the original array

    * Now binary search in temp (sorted), for end element
    * ########## Edge case
    *   lets say the element is -1, now we cannot return -1 from binary search
    *   cause -1 is also for not found, so we use Integer.MIN_VALUE,
    *   if Integer.MIN_VALUE is returned => put -1.
    *   else get the index of the element from map.
    *  */
    public int[] findRightIntervalMY(int[][] intervals) {
        int[] temp = new int[intervals.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
            temp[i] = intervals[i][0];
        }

        Arrays.sort(temp);
        int[] ans = new int[temp.length];
        for (int i = 0; i < intervals.length; i++) {
            int element = binSearch(temp, intervals[i][1]);

            ans[i] = (element == Integer.MIN_VALUE) ? -1 : map.get(element);
        }

        return ans;
    }
    public int binSearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;

        int ans = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < x) {
                l = mid + 1;
            }
            else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans == Integer.MIN_VALUE ? Integer.MIN_VALUE : arr[ans];
    }
}