package DSApractice.DP.Easy;

import java.util.HashMap;
import java.util.Map;

public class Climbing_Stairs_70 {

    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int stairs;
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            stairs = climbStairs(n - 1) + climbStairs(n - 2);
        }

        map.put(n, stairs);
        return stairs;
    }
}