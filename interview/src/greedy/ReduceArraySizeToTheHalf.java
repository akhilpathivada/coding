/**
 * author: akhilpathivada
 * time: 29/05/24 07:46
 *
 * https://leetcode.com/problems/reduce-array-size-to-the-half/description/
 *
 */
package greedy;

import java.util.*;

public class ReduceArraySizeToTheHalf {

    private final class Pair {

        private final int value;

        private final int freq;

        private Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    private int minSetSize(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        final PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        int deletedElements = 0;
        while (deletedElements < arr.length / 2) {
            deletedElements += maxHeap.poll().getValue();
        }
        return map.size() - maxHeap.size();
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(new ReduceArraySizeToTheHalf().minSetSize(arr));
    }
}
