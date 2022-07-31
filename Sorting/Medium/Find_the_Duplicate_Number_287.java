package DSApractice.LeetCode.Sorting.Medium;

public class Find_the_Duplicate_Number_287 {

    public int findDuplicate(int[] nums) {
        // cycle sort
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i -= 1;
            }
        }

        return nums[nums.length - 1];
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}