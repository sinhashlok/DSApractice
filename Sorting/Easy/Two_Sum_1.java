// https://leetcode.com/problems/two-sum/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.HashSet;

public class Two_Sum_1 {

    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();


        // finds if the other element exists in the set already,
        // if NOT, add the current element in the set
        // Else, find the index of the other element using index method
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return new int[]{i, index(nums, target - nums[i], i)};  // to find the element
            } else {
                set.add(nums[i]);
            }
        }

        return new int[] {-1, -1};
    }

    // finds the index of the element required form the array by linear traversal
    public int index(int[] nums, int x, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == k) {
                continue;
            }
            if (x == nums[i]) {
                return i;
            }
        }

        return -1;
    }
}