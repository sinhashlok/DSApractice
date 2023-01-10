package DSApractice.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class Continuous_Subarray_Sum_523 {

    /* Algo - LeetCode solution
    * sum -> 0, hashmap -> {0, 0}
    * we add the sum % k as key and the index + 1, as value
    * the value is index because we do need to check if the same remainder occurred before
    * */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i + 1); // + 1, because 0 index is with 0
            } else if (map.get(sum % k) < i) {
                // this is to check if array has at least 2 elements,
                // say array is 0, then the answer without this will be yes
                return true;
            }
        }

        return false;
    }
}