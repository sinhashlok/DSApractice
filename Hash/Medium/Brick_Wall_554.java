package DSApractice.Hash.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brick_Wall_554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(List<Integer> list : wall) {
            int x = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                x += list.get(i);
                map.put(x, map.getOrDefault(x, 0) + 1);
                max = Math.max(max, map.get(x));
            }
        }

        return wall.size() - max;
    }
}