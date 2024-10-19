/**
 * author: akhilpathivada
 * time: 05/06/24 15:48
 *
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
 *
 */
package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pilesQueue = buildPilesQueue(piles);
        processPiles(k, pilesQueue);
        return calculateRemainingStones(pilesQueue);
    }

    // Build a priority queue (max-heap) from the piles array
    private PriorityQueue<Integer> buildPilesQueue(int[] piles) {
        PriorityQueue<Integer> pilesQueue = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(piles).forEach(pilesQueue::add);
        return pilesQueue;
    }

    // Process the piles by reducing the largest pile k times
    private void processPiles(int k, PriorityQueue<Integer> pilesQueue) {
        while (k-- > 0) {
            int largest = pilesQueue.poll();
            pilesQueue.add(largest - largest / 2);
        }
    }

    // Calculate the total number of stones remaining
    private int calculateRemainingStones(PriorityQueue<Integer> pilesQueue) {
        return pilesQueue.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(new RemoveStonesToMinimizeTheTotal().minStoneSum(piles, k));
    }
}
