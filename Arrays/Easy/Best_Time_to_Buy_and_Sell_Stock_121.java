// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package DSApractice.Arrays.Easy;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,1};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int temp = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
//            profit = prices[i] - min;

//            if (temp < profit) {
//                temp = profit;
//            }
        }

        return profit;
    }
}