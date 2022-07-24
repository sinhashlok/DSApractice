// https://leetcode.com/problems/binary-search/

package DSApractice.LeetCode.Searching.Easy;

public class Binary_Search_704 {

    public int search(int[] arr, int target) {
        int l = 0, h = arr.length - 1, m = 0;

        while (l <= h)
        {
            m = l + (h - l) / 2;

            if (arr[m] == target)
                return m;

            if (arr[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }

        return -1;
    }

}
