package DSApractice.Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class Find_Subarrays_With_Equal_Sum_6171 {

    public boolean findSubarrays(int[] nums) {
        if (nums.length == 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            if (map.get(sum) > 1) {
                return true;
            }
        }

        return false;
    }
}