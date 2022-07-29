package DSApractice.LeetCode.Sorting.Hard;

import java.util.HashSet;
import java.util.Set;

public class First_Missing_Positive_41 {

    // Boolean approach
    public int firstMissingPositiveBoolean(int[] nums) {
        // create a new boolean array of size nums
        // we have to keep track of numbers that are => > 0 & <= nums.length

        // If an integer is missing it must be in the range [1..n],
        // if an integer is not missing then the answer is n+1.


        boolean[] arr = new boolean[nums.length];

        for (int i : nums) {
            if (i <= 0 || i > nums.length) {
                continue;
            }

            arr[i - 1] = true;  // if present
        }

        int i = 0;
        for (; i < arr.length; i++) {
            if (!arr[i]) {
                return i + 1;
            }
        }

        return i + 1;
    }


}