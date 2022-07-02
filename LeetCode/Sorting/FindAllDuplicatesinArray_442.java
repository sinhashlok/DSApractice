package DSApractice.LeetCode.Sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinArray_442 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        List<Integer> list = findDuplicates(nums);

        for (int n : list)
            System.out.print(n + " ");
    }

    static List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index+1) {
                ans.add(arr[index]);
            }
        }

        return ans;
    }

    static void swap(int[] nums, int i, int x) {
        int temp = nums[i];
        nums[i] = nums[x];
        nums[x] = temp;
    }
}
