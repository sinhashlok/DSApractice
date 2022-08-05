// https://leetcode.com/problems/search-insert-position/

package DSApractice.Searching.Easy;

public class Search_Insert_Position_35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1, m;

        while (l <= h) {
            m = l + (h - l) / 2;

            if (nums[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }

        return l;
    }
}
