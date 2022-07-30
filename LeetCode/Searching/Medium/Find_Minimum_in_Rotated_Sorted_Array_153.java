package DSApractice.LeetCode.Searching.Medium;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {

        // My approach
    public int findMinMy(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1, m = 0;

        if (nums[0] < nums[nums.length - 1]) return nums[0];

        while (l < r) {
            m = l + (r - l) / 2;

            if (nums[m] >= nums[0]) {
                l = m + 1;
            }
            else {
                if (nums[m] < nums[m - 1]) {
                    return nums[m];
                }
                else {
                    r = m - 1;
                }
            }
        }

        return nums[l];
    }

        // LeetCode
    public int findMinLeet(int[] nums) {
        // if list has just one element -> return the element
        if (nums.length == 1)
            return nums[0];

        int l = 0, r = nums.length - 1;

        // if last element is greater than the first -> array is not rotated
        if (nums[r] > nums[0])
            return nums[0];

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] > nums[m+1]) return nums[m + 1];
            if (nums[m-1] > nums[m]) return nums[m];

            if (nums[m] > nums[l]) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return -1;
    }
}