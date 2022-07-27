// https://leetcode.com/problems/self-dividing-numbers/

package DSApractice.LeetCode.Math.Easy;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers_728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelf(i)) {    // isSelf checks if the num satisfies the condition
                list.add(i);
            }
        }

        return list;
    }

    public boolean isSelf(int n) {
        int i = n;

        while (i != 0) {
            if (i % 10 == 0) {
                return false;
            }
            else if (n % (i % 10) != 0) {
                return false;
            }

            i /= 10;
        }

        return true;
    }
}