// https://leetcode.com/problems/fair-candy-swap/

package DSApractice.LeetCode.Searching.Easy;

import java.util.HashSet;
import java.util.Set;

public class Fair_Candy_Swap_888 {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sa = 0, sb = 0; // sum of aliceSizes and bobSizes, respectively

        for (int x : aliceSizes) {
            sa += x;
        }
        for (int x : bobSizes) {
            sb += x;
        }

        int delta =(sb - sa) / 2;
        // If Alice gives x, she expects to receive to x + delta

        Set<Integer> setB = new HashSet<>();
        for (int x : bobSizes) {
            setB.add(x);
        }

        for (int x : aliceSizes) {
            if (setB.contains(x + delta)) {
                return new int[] {x, x + delta};
            }
        }

        throw null;
    }

}
