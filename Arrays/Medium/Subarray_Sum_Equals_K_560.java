package DSApractice.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K_560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int subarraySumMy(int[] nums, int k) {
        // map keeps track of all the prefix sum at every element
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // add how many times prefix sum repeats at every element
        }

        int count = 0;
        sum = 0;
        for (int num : nums) {
            if (map.containsKey(k)) {
                count += map.get(k);
            }
            sum += num;

            map.put(sum, map.getOrDefault(sum, 0) - 1);
            if (map.get(sum) == 0) {
                map.remove(sum);
            }

            k += num;
        }

        return count;
    }
}