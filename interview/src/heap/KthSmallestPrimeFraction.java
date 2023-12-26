/**
 * @author akhilpathivada
 * <p>
 * date : 26/12/23
 * time: 05:27
 *
 * https://leetcode.com/problems/k-th-smallest-prime-fraction
 * https://www.codingninjas.com/studio/problems/k-th-smallest-prime-fraction_1404697
 *
 * Time Complexity: O(n ^ 2) * O(log(k))
 * Space Complexity: O(k)
 *
 */
package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    private class Pair implements Comparable<Pair> {

        private final int i;

        private final int j;

        private final double fraction;

        private Pair(int i, int j, double fraction) {
            this.i = i;
            this.j = j;
            this.fraction = fraction;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.fraction, this.fraction);
        }
    }

    private int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                double primeFraction = (double) arr[i] / arr[j];
                if (maxHeap.size() < k) {
                    maxHeap.offer(new Pair(arr[i], arr[j], primeFraction));
                } else if (!maxHeap.isEmpty() && primeFraction < maxHeap.peek().fraction) {
                    maxHeap.poll();
                    maxHeap.offer(new Pair(arr[i], arr[j], primeFraction));
                }
            }
        }
        new ArrayList<>(Arrays.asList(new int[] { -1, -1 }));
        return maxHeap.isEmpty() ? new int[] { -1, -1 } : new int[] { maxHeap.peek().i, maxHeap.peek().j };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int k = 3;
        System.out.println(Arrays.toString(new KthSmallestPrimeFraction().kthSmallestPrimeFraction(arr, k)));
    }
}
