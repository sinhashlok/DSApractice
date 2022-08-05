// https://leetcode.com/problems/koko-eating-bananas/

package DSApractice.Searching.Medium;

import java.util.Arrays;

public class Koko_Eating_Bananas_875 {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == h) {
            int res = 0;
            for (int i : piles) {
                res = Math.max(i, res);
            }

            return res;
        }

        int start = 0, end = 0;
        for (int i : piles) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }

        while (start < end) {
            // hourSpent stands for the total hour Koko spends.
            int mid = (start + end) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / mid);
            }

            if (hourSpent <= h) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end; // start == end
    }
}