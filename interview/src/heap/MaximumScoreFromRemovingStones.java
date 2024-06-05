/**
 * author: akhilpathivada
 * time: 05/06/24 16:07
 *
 * https://leetcode.com/problems/maximum-score-from-removing-stones/description/
 *
 */
package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {

    private int maximumScore(int a, int b, int c) {
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        maxHeap.addAll(Arrays.asList(a, b, c));
        int score = 0;
        while (maxHeap.size() > 1) {
            int remainingStonesInPile1 = maxHeap.poll() - 1;
            int remainingStonesInPile2 = maxHeap.poll() - 1;
            ++score;
            if (remainingStonesInPile1 > 0) {
                maxHeap.add(remainingStonesInPile1);
            }
            if (remainingStonesInPile2 > 0) {
                maxHeap.add(remainingStonesInPile2);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int a = 2, b = 4, c = 6;
        System.out.println(new MaximumScoreFromRemovingStones().maximumScore(a, b, c));
    }
}
