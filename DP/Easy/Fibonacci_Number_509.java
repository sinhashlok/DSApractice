package DSApractice.DP.Easy;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci_Number_509 {

    Map<Integer, Integer> map = new HashMap();
    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res;
        if (n < 2) {
            res = n;
        } else {
            res = fib(n - 1) + fib(n - 2);
        }

        map.put(n, res);
        return res;
    }
}