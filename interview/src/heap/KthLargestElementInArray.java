/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Time Complexity : O(N * log(K))
 * Space Complexity : O(K)
 *
 * */
package heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; ++i) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        System.out.println(new KthLargestElementInArray().findKthLargest(nums, k));
    }
}
