// https://leetcode.com/problems/check-if-n-and-its-double-exist/

package DSApractice.LeetCode.Searching.Easy;

import java.util.HashSet;
import java.util.Set;

public class Check_If_N_and_Its_Double_Exist_1349 {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int x : arr) {
            if (set.contains(2 * x) || (x % 2 == 0 && set.contains(x / 2))) {
                return true;
            }
            set.add(x);
        }

        return false;
    }
}
