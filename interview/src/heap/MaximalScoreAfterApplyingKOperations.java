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
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long score = 0;
        Arrays.stream(nums).forEach(maxHeap::add);
        while (k-- > 0) {
            int element = maxHeap.poll();
            score += element;
            maxHeap.add((int) Math.ceil(element / 3.0));
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println(new MaximalScoreAfterApplyingKOperations().maxKelements(nums, k));
    }
}
