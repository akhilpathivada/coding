/**
 * Date 30/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Time Complexity : O(N * K)
 * Space Complexity : O(N)
 */

package misc;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {

    private int maxProfit(int[] prices, int k) {
        int n = prices.length;
        // base case
        if (k <= 0 || n == 0) {
            return 0;
        }
        // holds the 'k' min prices
        int[] minPrices = new int[k];
        // holds the 'k' max profits
        int[] maxProfits = new int[k];
        Arrays.fill(minPrices, Integer.MAX_VALUE);
        Arrays.fill(maxProfits, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = 0; j < k; ++j) {
                minPrices[j] = Math.min(minPrices[j], price - (j > 0 ? maxProfits[j - 1] : 0));
                maxProfits[j] = Math.max(maxProfits[j], price - minPrices[j]);
            }
        }
        return maxProfits[k - 1];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int k = 2;
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(prices, k));
    }
}
