/**
 * author: akhilpathivada
 * time: 07/06/24 18:41
 *
 * https://leetcode.com/problems/distant-barcodes/
 *
 */
package greedy;

import java.util.*;

public class DistantBarcodes {

    private int[] rearrangeBarcodes(int[] barcodes) {
        final int n = barcodes.length;
        final int[] result = new int[n];
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int code : barcodes) {
            frequencyMap.put(code, frequencyMap.getOrDefault(code, 0) + 1);
        }
        final PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());
        // first fill even positions and then fill the odd positions
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int freq = maxHeap.peek().getValue();
            while (freq-- > 0) {
                result[i] = maxHeap.peek().getKey();
                i += 2;
                if (i >= n) { // now start filling odd positions
                    i = 1;
                }
            }
            maxHeap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(barcodes)));
    }
}
