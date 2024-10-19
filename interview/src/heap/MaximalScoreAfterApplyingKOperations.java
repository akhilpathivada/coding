/**
 * author: akhilpathivada
 * time: 14/10/24 07:32
 *
 * https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/
 *
 */
package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> elementsQueue = buildElementsQueue(nums);
        return calculateScore(elementsQueue, k);
    }

    // Build a priority queue (max-heap) from the nums array
    private PriorityQueue<Integer> buildElementsQueue(final int[] nums) {
        PriorityQueue<Integer> elementsQueue = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(nums).forEach(elementsQueue::add);
        return elementsQueue;
    }

    // Calculate the score using the max-heap
    private long calculateScore(final PriorityQueue<Integer> elementsQueue, int k) {
        long score = 0;
        while (k-- > 0) {
            int largest = elementsQueue.poll();
            score += largest;
            elementsQueue.add((int) Math.ceil(largest / 3.0));
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println(new MaximalScoreAfterApplyingKOperations().maxKelements(nums, k));
    }
}
