package misc;

/**
 * Date 08/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    private int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int effectiveBuyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            profit = Math.max(profit, prices[i] - effectiveBuyPrice - fee);
            effectiveBuyPrice = Math.min(effectiveBuyPrice, prices[i] - profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices, fee));
    }
}
