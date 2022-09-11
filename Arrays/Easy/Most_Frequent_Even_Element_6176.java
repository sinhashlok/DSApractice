package DSApractice.Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class Most_Frequent_Even_Element_6176 {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (i % 2 == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        if (map.size() == 0) {
            return -1;
        }

        int res = Integer.MIN_VALUE;
        int count = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > res) {
                res = e.getValue();
                count = e.getKey();
            } else if (e.getValue() == res) {
                count = count < e.getKey() ? count : e.getKey();
                res = map.get(count);
            }
        }

        return count;
    }
}