package DSApractice.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddtoArrayFormofInteger {
    public static void main(String[] args) {
        int[] arr = {1,2,0,0};
        int k = 34;

        System.out.println(adding(arr, k).toString());
    }

    static List<Integer> adding(int[] num, int k) {
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
