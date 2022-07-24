// https://leetcode.com/problems/add-to-array-form-of-integer/

package DSApractice.LeetCode.Arrays.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Add_to_Array_Form_of_Integer_989 {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int ans = 0;

        for (int i = 0; i < num.length; i++)
            ans += num[i]*(Math.pow(10, num.length - i - 1));

        ans += k;

        List<Integer> f = new ArrayList<>();
        while (ans != 0)
        {
            f.add(ans%10);
            ans /= 10;
        }

        Collections.reverse(f);

        return f;
    }
}
