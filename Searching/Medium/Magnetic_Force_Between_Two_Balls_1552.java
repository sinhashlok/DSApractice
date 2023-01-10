package DSApractice.Searching.Medium;

import java.util.Arrays;

public class Magnetic_Force_Between_Two_Balls_1552 {

    /*
    *
    *
    * Define function count(d) that counts the number of balls can be placed in to baskets,
    * under the condition that the minimum distance between any two balls is d.
    *
    * We want to find the maximum d such that count(d) == m.
    * - If the count(d) > m , we have too many balls placed, so d is too small.
    * - If the count(d) < m , we don't have enough balls placed, so d is too large.
    * */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 0, hi = position[position.length-1], optimal = 0, mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (canPut(position, m, mid)) {
                optimal = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return optimal;
    }

    /*
     * returns whether we can put m balls such that minimum distance between two consecutive ball is always greater than or equal to the max.
     */
    private boolean canPut(int[] positions, int m, int max) {
        int count = 1, last = positions[0];

        for (int position : positions) {
            if (position - last >= max) {
                last = position;
                count++;
            }
        }

        return count >= m;
    }
}