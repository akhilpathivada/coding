/**
 * author: akhilpathivada
 * time: 16/05/24 17:16
 *
 * https://leetcode.com/problems/most-profit-assigning-work/
 *
 */
package greedy;

import java.util.Arrays;

public class MostProfitAssigningWork {

    private static final class Pair {

        private final int difficulty;

        private final int profit;

        private Pair(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    private int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final int n = difficulty.length;
        final Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new Pair(difficulty[i], profit[i]);
        }
        // sort based on max. profit
        Arrays.sort(pairs, (a, b) -> b.profit - a.profit);
        Arrays.sort(worker);
        int totalProfit = 0;
        int i = 0;
        int j = worker.length - 1;
        while (i < n && j >= 0) {
            if (worker[j] >= pairs[i].difficulty) {
                totalProfit += pairs[i].profit;
                --j;
            } else {
                ++i;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(difficulty, profit, worker));
    }
}
