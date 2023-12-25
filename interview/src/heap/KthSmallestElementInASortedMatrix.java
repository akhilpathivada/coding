/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 17:01
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * https://www.codingninjas.com/studio/problems/kth-smallest-element_3621004
 *
 * Time Complexity: O(n ^ 2) * O(log(k))
 * Space Complexity: O(k)
 */
package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    private int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(row[j]);
                } else if (!maxHeap.isEmpty() && row[j] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(row[j]);
                }
            }
        }
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix, k));
    }
}
