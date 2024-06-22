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

    private int findLeastNumOfUniqueInts(int[] arr, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(map.values());
        while (k > 0) {
            k -= maxHeap.poll();
        }
        return k < 0 ? maxHeap.size() + 1 : maxHeap.size();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(new LeastNumberOfUniqueIntegersAfterKRemovals().findLeastNumOfUniqueInts(arr, k));
    }
}
