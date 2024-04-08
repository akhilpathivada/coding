/**
 * Date 08/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package dp.statemachine;

public class BestTimeToBuyAndSellStockWithCooldown {

    private int maxProfit(int[] prices) {
        // base case
        if (prices.length == 0) {
            return 0;
        }
        // 3 states (state machine technique)
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, prevSold);
        }
        return Math.max(sold, reset);
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
    }
}
