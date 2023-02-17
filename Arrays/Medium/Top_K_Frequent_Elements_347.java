package DSApractice.Arrays.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements_347 {

    // Naive approach
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // add all elements and their frequency in map
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Make a max-heap PQ and add frequencies from map in PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int x = pq.poll(), num = 0;

            // find an element corresponding to x (=pq.poll())
            // get the corresponding number, and remove it from map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == x) {
                    num = entry.getKey();
                    map.remove(num);
                    break;
                }
            }

            res[i] = num;
        }

        return res;
    }
}