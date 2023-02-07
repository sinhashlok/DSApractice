package DSApractice.Greedy.Medium;

import java.util.Arrays;

public class Maximum_Number_of_Coins_You_Can_Get_1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int l = piles.length - 2;   // track of your pile
        int f = 0;  // track of Bob's pile
        int sum = 0;

        while (l > f) {
            sum += piles[l];
            l -= 2;
            f += 1;
        }

        return sum;
    }
}