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

    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pilesQueue = buildPilesQueue(a, b, c);
        return calculateScore(pilesQueue);
    }

    // Build a priority queue (max-heap) using the initial stone counts from the piles
    private PriorityQueue<Integer> buildPilesQueue(final int a, final int b, final int c) {
        PriorityQueue<Integer> pilesQueue = new PriorityQueue<>((x, y) -> y - x);
        pilesQueue.addAll(Arrays.asList(a, b, c)); // Add the initial counts to the queue
        return pilesQueue;
    }

    // Calculate the total score by removing stones from the two largest piles until one is empty
    private int calculateScore(final PriorityQueue<Integer> pilesQueue) {
        int score = 0;
        while (pilesQueue.size() > 1) {
            int first = pilesQueue.poll() - 1;
            int second = pilesQueue.poll() - 1;
            reAddToQueue(first, pilesQueue);
            reAddToQueue(second, pilesQueue);
            ++score;
        }
        return score;
    }

    // Re-add a pile back to the queue if there are stones remaining
    private void reAddToQueue(final int pile, final PriorityQueue<Integer> pilesQueue) {
        if (pile > 0) {
            pilesQueue.add(pile);
        }
    }

    public static void main(String[] args) {
        int a = 2, b = 4, c = 6;
        System.out.println(new MaximumScoreFromRemovingStones().maximumScore(a, b, c));
    }
}
