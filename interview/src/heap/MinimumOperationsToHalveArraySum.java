/**
 * author: akhilpathivada
 * time: 14/10/24 08:03
 *
 * https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
 *
 */
package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {

    private int halveArray(int[] nums) {
        final PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double totalSum = Arrays.stream(nums).mapToDouble(num -> num).sum();
        double currentSum = totalSum;
        int operations = 0;
        Arrays.stream(nums).forEach(num -> maxHeap.add((double) num));
        while (currentSum > totalSum / 2) {
            double largest = maxHeap.poll();
            double reduced = largest / 2;
            currentSum -= reduced;
            maxHeap.add(reduced);
            ++operations;
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] nums = {5, 19, 8, 1};
        System.out.println(new MinimumOperationsToHalveArraySum().halveArray(nums));
    }
}
