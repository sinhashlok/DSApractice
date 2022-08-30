package DSApractice.DP.Easy;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_II_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int m = 1;

        while (m <= rowIndex + 1) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                if (i == 0 || i == m - 1) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1) + list.get(i));
                }
            }

            list.clear();
            list.addAll(temp);
            m += 1;
        }

        return list;
    }
}