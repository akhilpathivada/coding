/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * https://www.codingninjas.com/studio/problems/0-1-knapsack_920542
 *
 * Time Complexity : O(2 ^ N)
 * Space Complexity : O(N)
 */
package dp;

public class ZeroOneKnapsackProblemI {

        private int fillKnapsack(int[] value, int[] weight, int maxWeight, int n) {
                // base case
                if (maxWeight == 0 || n == 0) {
                        return 0;
                }
                if (weight[n - 1] > maxWeight) {
                        return fillKnapsack(value, weight, maxWeight, n - 1);
                }
                return Math.max(value[n - 1] + fillKnapsack(value, weight, maxWeight - weight[n - 1], n - 1),
                        fillKnapsack(value, weight, maxWeight, n - 1));
        }

        public static void main(String[] args) {
                int[] value = new int[] { 60, 100, 120 };
                int[] weight = new int[] { 10, 20, 30 };
                int maxWeight = 50;
                int n = value.length;
                System.out.println("Maximum profit = " +
                        new ZeroOneKnapsackProblemI().fillKnapsack(value, weight, maxWeight, n));
        }
}
