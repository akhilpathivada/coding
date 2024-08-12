/**
 * date 12/08/24 16:02
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 *
 */
package heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    private final PriorityQueue<Integer> minHeap;

    private final int k;

    private int insert(int num) {
        if (minHeap.size() < k) {
            minHeap.offer(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }
        return minHeap.peek();
    }

    public KthLargestElementInAStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            insert(num);
        }
    }

    public int add(int val) {
        return insert(val);
    }

    public static void main(String[] args) {
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
