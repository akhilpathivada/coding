/**
 * author: akhilpathivada
 * time: 22/06/24 08:54
 *
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
 *
 */
package heap;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = buildFrequencyMap(arr);
        PriorityQueue<Integer> frequencyQueue = buildFrequencyQueue(frequencyMap);
        while (k > 0) {
            k -= frequencyQueue.poll();
        }
        return k < 0 ? frequencyQueue.size() + 1 : frequencyQueue.size();
    }

    // Build a frequency map to count occurrences of each integer
    private Map<Integer, Integer> buildFrequencyMap(final int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(arr).forEach(num -> frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1));
        return frequencyMap;
    }

    // Build a priority queue (min-heap) by adding all the frequencies
    private PriorityQueue<Integer> buildFrequencyQueue(final Map<Integer, Integer> frequencyMap) {
        return new PriorityQueue<>(frequencyMap.values()); // Add all frequencies to a min-heap
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(new LeastNumberOfUniqueIntegersAfterKRemovals().findLeastNumOfUniqueInts(arr, k));
    }
}
