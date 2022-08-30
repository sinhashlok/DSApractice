package DSApractice.DP.Easy;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_118 {

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        int m = 1;

        while (m <= n) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                if (i == 0 || i == m - 1) {
                    temp.add(1);
                } else {
                    temp.add(list.get(list.size() - 1).get(i - 1) + list.get(list.size() - 1).get(i));
                }
            }

            list.add(temp);
            m += 1;
        }

        return list;
    }
}