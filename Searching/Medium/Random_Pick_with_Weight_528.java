package DSApractice.Searching.Medium;

import java.util.Random;

public class Random_Pick_with_Weight_528 {

    /*
    * Use accumulated freq array to get idx.
    * w[] = {2,5,3,4} => wSum[] = {2,7,10,14}
    * then get random val random.nextInt(14)+1, idx is in range [1,14]
    *   idx in [1,2] return 0
    *   idx in [3,7] return 1
    *   idx in [8,10] return 2
    *   idx in [11,14] return 3
    *
    * # we are actually using the WIDTH of each range as the weight of the indexes
    * (accumulated sum increases more with a higher weight)
    * for example, for index 1 the range is [3, 7] which is longer than other ranges (since it has higher weight, 5),
    * and therefore the random pick falls into that range with higher probability.
    * */

    int[] wSum;
    Random random = new Random();
    public void Solution(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }

        wSum = w;
    }

    public int pickIndex() {
        int max = wSum[wSum.length - 1], min = wSum[0];
        int index = random.nextInt(wSum[wSum.length-1]) + 1;

        int l = 0, r = wSum.length - 1, m = 0;
        while (l < r) {
            m = l + (r - l) / 2;

            if (wSum[m] == index) {
                return m;
            } else if (wSum[m] < index) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}