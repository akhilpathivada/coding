/**
 * author: akhilpathivada
 * time: 05/06/24 15:48
 *
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
 *
 */
package heap;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    private int minStoneSum(int[] piles, int k) {
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            maxHeap.add(pile);
        }
        while (k-- > 0) {
            int pile = maxHeap.poll();
            pile -= (pile / 2);
            maxHeap.add(pile);
        }
        int total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }
        return total;
    }

    public static void main(String[] args) {
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(new RemoveStonesToMinimizeTheTotal().minStoneSum(piles, k));
    }
}
