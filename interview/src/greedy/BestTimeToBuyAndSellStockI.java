/**
 * Date 30/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package greedy;

public class BestTimeToBuyAndSellStockI {
        
        private int maxProfit(int[] prices) {
                if (prices.length == 0) {
                        return 0;
                }
                int minPrice = prices[0];
                int maxProfit = 0;
                for (int i = 1; i < prices.length; ++i) {
                        minPrice = Math.min(minPrice, prices[i]);
                        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                }
                return maxProfit;
        }
        
        public static void main(String[] args) {
                int[] prices = { 7, 1, 5, 3, 6, 4 };
                System.out.println(new BestTimeToBuyAndSellStockI().maxProfit(prices));
         }
}
