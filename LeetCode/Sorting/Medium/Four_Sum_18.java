// https://leetcode.com/problems/4sum/

package DSApractice.LeetCode.Sorting.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum_18 {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 2, 4, 5};
        List<List<Integer>> list = fourSum(arr, 0);

        for (List<Integer> i : list) {
            for (Integer j : i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
    }


    static List<List<Integer>> fourSum(int[] nums, int target) {

        // first, sort the array
        Arrays.sort(nums);

        if (nums.length < 4) {
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }

        // I will you four pointers
        // two will be at start and end, respectively
        // the rest two will go in the middle
        List<List<Integer>> list = new ArrayList<>();
        int i = 0, j = nums.length -1;

        while (i < j - 2) {
                // now we initialise the pointers that will travel between the end pointers
                int m = i + 1;
                int n = j - 1;

                while (m < n) {
                    int sum = nums[i] + nums[m] + nums[n] + nums[j];

                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[m], nums[n], nums[j]));

                        do {
                            m++;
                        } while (m < n && nums[m] == nums[m - 1]);
                        do {
                            n--;
                        } while (n > m && nums[n] == nums[n + 1]);
                    }
                    else if (sum < target) {
                        do {
                            m++;
                        } while (m < n && nums[m] == nums[m - 1]);
                    }
                    else {
                        do {
                            n--;
                        } while (n > m && nums[n] == nums[n + 1]);
                    }
                }

                if (nums[i] == nums[j]) {
                    do {
                        i++;
                    } while (i < j && nums[i] == nums[i - 1]);
                    do {
                        j--;
                    } while (i < j && nums[j] == nums[i + 1]);
                }
                else if (nums[i] + nums[j] > target) {
                    j--;
                }
                else {
                    i++;
                }
        }

        return list;
    }
}