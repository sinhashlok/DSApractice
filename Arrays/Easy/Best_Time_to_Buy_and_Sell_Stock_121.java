// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package DSApractice.Arrays.Easy;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int profit = 0;
        int l = 0, r = 1;
        while (l <= r && r < prices.length) {
            if (prices[l] >= prices[r]) {
                l = r;
            }

            profit = Math.max(profit, prices[r] - prices[l]);
            r++;
        }

        return profit;
    }
}