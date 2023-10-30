/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
 * https://www.codingninjas.com/studio/problems/cost-to-cut-a-chocolate_3208460
 *
 * Time Complexity : O(C ^ 3)
 * Space Complexity : O(C ^ 2)
 * */

package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutAStick {

    private int f(int i, int j, List<Integer> cuts) {
        // base case
        if (i > j) {
            return 0;
        }
        // take min of all partitions
        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; ++index) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + f(i, index - 1, cuts) + f(index + 1, j, cuts);
            min = Math.min(min, cost);
        }
        return min;
    }

    private int minCostFromTabulation(int c, List<Integer> cuts) {
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; --i) {
            for (int j = 1; j <= c; ++j) {
                if (i > j) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int index = i; index <= j; ++index) {
                    int cost = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][index - 1] + dp[index + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }


    private int minCost(int n, int[] cuts) {
        int c = cuts.length;
        List<Integer> list = new ArrayList<>();
        // convert into list
        for (int i : cuts) {
            list.add(i);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int minCostFromRecursion = f(1, c, list);
        int minCostFromTabulation = minCostFromTabulation(c, list);
        return minCostFromTabulation;
    }

    public static void main(String[] args) {
        int[] cuts = { 5, 6, 1, 4, 2 };
        int n = 9;
        System.out.println("The minimum cost incurred: " + new MinimumCostToCutAStick().minCost(n, cuts));
    }
}
