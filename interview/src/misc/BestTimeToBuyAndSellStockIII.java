/**
 * Date 30/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package misc;

public class BestTimeToBuyAndSellStockIII {

        private int maxProfit2(int[] prices) {
                int n = prices.length;
                if (n == 0) {
                        return 0;
                }
                // capture min price to buy for 1st transaction
                int minPrice1 = Integer.MAX_VALUE;
                // capture max profit to sell for 1st transaction
                int profit1 = Integer.MIN_VALUE;

                // capture min price to buy for 2nd transaction
                int minPrice2 = Integer.MAX_VALUE;
                // capture max profit to sell for 2nd transaction
                int profit2 = Integer.MIN_VALUE;

                for (int price : prices) {
                        minPrice1 = Math.min(minPrice1, price);
                        profit1 = Math.max(profit1, price - minPrice1);
                        minPrice2 = Math.min(profit1, price);
                        profit2 = Math.max(profit2, price - minPrice2);
                }
                return profit2;
        }
        
        private int maxProfit(int[] prices) {
                int n = prices.length;
                if (n == 0) {
                        return 0;
                }
                // captures max profit we can get if we sell at this particular point
                int[] left = new int[n];
                // captures max profit we can get if we buy at this particular point
                int[] right = new int[n];
                // compute left array
                int min = prices[0];
                for (int i = 1; i < n; ++i) {
                        min = Math.min(min, prices[i]);
                        int profit = prices[i] - min;
                        left[i] = Math.max(left[i - 1], profit);
                }
                // compute right array
                int max = prices[n - 1];
                for (int i = n - 2; i >= 0; --i) {
                        max = Math.max(max, prices[i]);
                        int profit = max - prices[i];
                        right[i] = Math.max(right[i + 1], profit);
                }
                int maxPro = 0;
                for (int i = 0; i < n; ++i) {
                        maxPro = Math.max(maxPro, left[i] + right[i]);
                }
                return maxPro;
        }
        
        public static void main(String[] args) {
                int[] prices = { 7, 1, 5, 3, 6, 4 };
                System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit2(prices));
        }
}
