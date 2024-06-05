/**
 * author: akhilpathivada
 * time: 05/06/24 16:38
 *
 * https://leetcode.com/problems/most-frequent-ids/
 *
 */
package heap;

import java.util.*;

public class MostFrequentIDs {

    private final class Pair {

        private final int id;

        private final long freq;

        private Pair(int id, long freq) {
            this.id = id;
            this.freq = freq;
        }
    }

    private long[] mostFrequentIDs(int[] nums, int[] freq) {
        final int n = nums.length;
        final Map<Integer, Long> idToFrequencyMap = new HashMap<>();
        final PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.freq, a.freq)); // store (id, freq)
        final long[] result = new long[n];
        for (int i = 0; i < n; ++i) {
            idToFrequencyMap.put(nums[i], idToFrequencyMap.getOrDefault(nums[i], 0L) + freq[i]);
            maxHeap.add(new Pair(nums[i], idToFrequencyMap.get(nums[i])));
            while (idToFrequencyMap.get(maxHeap.peek().id) != maxHeap.peek().freq) {
                maxHeap.poll();
            }
            result[i] = maxHeap.peek().freq;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1};
        int[] freq = {3, 2, -3, 1};
        System.out.println(Arrays.toString(new MostFrequentIDs().mostFrequentIDs(nums, freq)));
    }
}
