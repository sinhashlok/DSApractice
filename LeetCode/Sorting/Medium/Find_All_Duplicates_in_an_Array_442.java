package DSApractice.LeetCode.Sorting.Medium;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array_442 {


    // cycle sort approach
    public List<Integer> findDuplicatesCycleSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i , nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }

        return list;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDuplicatesMinuOne(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }

            nums[index] = -nums[index]; // if it already exists make it negative
        }
        return res;
    }
}