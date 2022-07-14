// https://leetcode.com/problems/pascals-triangle/

package DSApractice.LeetCode.Arrays.Easy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_118 {
    public static void main(String[] args) {
        int n = 5;

        List<List<Integer>> res = generate(n);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    static List<List<Integer>> generate(int n) {
        List<List<Integer>> arr = new ArrayList<>();
        int m = 1;
        while (m <= n) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (i == 0 || i == m - 1) {
                    res.add(1);
                } else {
                    res.add(arr.get(arr.size() - 1).get(i - 1) + arr.get(arr.size() - 1).get(i));
                }
            }
            arr.add(res);
            m += 1;
        }

        return arr;
    }
}