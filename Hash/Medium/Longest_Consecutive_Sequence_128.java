package DSApractice.Hash.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_128 {
    // O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int count = 1;

                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    count += 1;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }

    // O(nlogn)
    public int longestConsecutiveMyApproach(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }


        }

        return Math.max(max, count);
    }
}