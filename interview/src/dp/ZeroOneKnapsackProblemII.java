/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * https://www.codingninjas.com/studio/problems/0-1-knapsack_920542
 *
 * Time Complexity : O(N * W)
 * Space Complexity : O(N * W)
 */
package dp;

public class ZeroOneKnapsackProblemII {

        private int fillKnapsack(int[] value, int[] weight, int maxWeight, int n) {
                // base case
                if (maxWeight == 0 || n == 0) {
                        return 0;
                }
                // row : denotes weight to be filled with
                // column : denotes weight to be filled (available weight)
                int[][] table = new int[n + 1][maxWeight + 1];
                for (int i = 0; i <= n; ++i) {
                        for (int j = 0; j <= maxWeight; ++j) {
                                if (i == 0 || j == 0) { // if weight is 0 or weight to be filled is 0
                                        table[i][j] = 0;
                                } else if (weight[i - 1] > j) { // if weight to be filled with
                                        // is greater than available weight
                                        table[i][j] = table[i - 1][j];
                                } else {
                                        table[i][j] = Math.max(value[i - 1] + table[i - 1][j - weight[i - 1]],
                                                table[i - 1][j]);
                                }
                        }
                }
                return table[n][maxWeight];
        }
        
        public static void main(String[] args) {
                int[] value = new int[] { 60, 100, 120 };
                int[] weight = new int[] { 10, 20, 30 };
                int maxWeight = 50;
                int n = value.length;
                System.out.println("Maximum profit = " +
                        new ZeroOneKnapsackProblemII().fillKnapsack(value, weight, maxWeight, n));
        }
}
