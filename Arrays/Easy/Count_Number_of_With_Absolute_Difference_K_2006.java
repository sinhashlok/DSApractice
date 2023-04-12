// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

package DSApractice.Arrays.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Count_Number_of_With_Absolute_Difference_K_2006 {
    public static void main(String[] args) {
        int[] nums = {7,7,8,3,1,2,7,2,9,5};

            // MY APPROACH
//        System.out.println(countKDifferenceMY(nums, 6));
        System.out.println(countKDifference(nums, 6));
    }

    static int countKDifferenceMY(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(k + nums[i])) {
                count += map.get(k + nums[i]);
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }

    static int countKDifference(int[] nums, int k) {
        /*
            Since nums[i] is in the [1...100] range, we can count each number using an array.
            Now, we can sweep the counts, and accumulate the product of k-apart counts.
        */

        int[] cnt = new int[201];
        int res = 0;

        for (int n : nums) {
            cnt[n] += 1;
        }
        for (int i = k + 1; i < 201; ++i) {
            // the cnt[i-k] -> checks if that element is there or not, if yes then its 1, else 0
            // so product is either 1 if YES, or 0 if NO
            res += cnt[i] * cnt[i - k];
        }

        return res;
    }
}
