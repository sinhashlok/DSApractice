package DSApractice.DP.Easy;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i : prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }

        return profit;
    }
}