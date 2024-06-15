/**
 * @author akhilpathivada
 * <p>
 * date : 03/04/24
 * time: 14:41
 *
 * https://leetcode.com/problems/ipo/description/
 *
 * Time Complexity: O(k * log n)
 * Space Complexity: O(n)
 *
 */
package heap;

import java.util.PriorityQueue;

public class IPO {

    private final class Pair {

        private final int capital;

        private final int profit;

        private Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    private int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int n = capital.length;
        final PriorityQueue<Pair> minCapitalHeap = new PriorityQueue<>(
                (pair1, pair2) -> Integer.compare(pair1.capital, pair2.capital));
        final PriorityQueue<Pair> maxProfitHeap = new PriorityQueue<>(
                (pair1, pair2) -> Integer.compare(pair2.profit, pair1.profit));
        for (int i = 0; i < n; ++i) {
            minCapitalHeap.add(new Pair(capital[i], profits[i]));
        }
        while (k-- > 0) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            if (!maxProfitHeap.isEmpty()) {
                w += maxProfitHeap.poll().profit;
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        System.out.println(new IPO().findMaximizedCapital(k, w, profits, capital));
    }
}
