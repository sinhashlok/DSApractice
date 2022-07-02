// https://leetcode.com/problems/first-missing-positive/

package DSApractice.LeetCode.Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class First_Missing_Positive_41 {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        int index = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                set.add(nums[i]);
                if (set.contains(index))
                    index += 1;
            }
        }

        return index;
    }
}
