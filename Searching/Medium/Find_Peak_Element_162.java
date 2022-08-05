package DSApractice.LeetCode.Searching.Medium;

public class Find_Peak_Element_162 {

        // My approach
    public int findPeakElementMY(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1, m;

        while (l <= h) {
            m = l + (h - l) / 2;

            if ( (m == 0 || nums[m - 1] <= nums[m]) && (m == n - 1 || nums[m + 1] <= nums[m]) ) {
                return m;
            }

            if (m > 0 && nums[m - 1] >= nums[m]) {
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return -1;
    }

        // LeetCode
    public int findPeakElementLeet(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}