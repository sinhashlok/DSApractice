package DSApractice.Greedy.Medium;

import java.util.HashMap;

public class Reduce_Array_Size_to_The_Half_1338 {

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int x : arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int[] counting = new int[arr.length + 1];
        for (int freq : count.values()) {
            counting[freq]++;
            // will make the index corresponding to frequency +1
        }

        int ans = 0, removed = 0, half = arr.length / 2, freq = arr.length;
        while (removed < half) {
            ans += 1;
            while (counting[freq] == 0) {
                freq--;
            }

            // when we get an element != 0 => a / many number exist that index_number of times.
            // so, we add freq in number.
            removed += freq;
            counting[freq]--;
        }

        return ans;
    }
}