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

    private int minStoneSum(int[] piles, int k) {
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(piles).forEach(maxHeap::add);
        while (k-- > 0) {
            int pile = maxHeap.poll();
            maxHeap.add(pile - pile / 2);
        }
        return maxHeap.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(new RemoveStonesToMinimizeTheTotal().minStoneSum(piles, k));
    }
}
