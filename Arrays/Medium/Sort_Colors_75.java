// https://leetcode.com/problems/sort-colors/

package DSApractice.Arrays.Medium;

public class Sort_Colors_75 {

    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        // left - track of 0 (from left to right)
        // mid - track of 1
        // right - track of 2 (from right to left)

        while (mid <= right) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                swap(nums, mid++, left++);
            } else if (nums[mid] == 2) {
                swap(nums, mid, right--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColorsMY(int[] A) {

        if (A == null || A.length < 2) return;
        int low = 0;
        int high = A.length - 1;
        for (int i = low; i <= high; ) {
            if (A[i] == 0) {
                // swap A[i] and A[low] and i,low both ++
                int temp = A[i];
                A[i] = A[low];
                A[low] = temp;
                i++;
                low++;
            } else if (A[i] == 2) {
                //swap A[i] and A[high] and high--;
                int temp = A[i];
                A[i] = A[high];
                A[high] = temp;
                high--;
            } else
                i++;
        }
    }

}