/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * Get the median from a stream of numbers (running integers)
 *
 * Given that integers are read from a data stream. Find median of elements read so for in efficient way.
 * For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3....
 *
 *
 * Time Complexity  : O(log(N))
 * Space Complexity : O(N)
 * */

package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromDataStream {

    private static void balanceMinMaxHeaps(Queue<Integer> minHeap, Queue<Integer> maxHeap) {

        if (maxHeap.size() > minHeap.size() + 1) { // if there are more elements in 1nd half
            // remove one element from 1st half and put into 2nd half
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) { // if there are more elements in 2nd half
            // remove one element from 2nd half and put into 1st half
            maxHeap.offer(minHeap.poll());
        }
    }

    private static int getMedian(Queue<Integer> minHeap, Queue<Integer> maxHeap) {

        int median;

        if (maxHeap.size() > minHeap.size()) { // median exists in 1st half
            median = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) { // median exists in 2nd half
            median = minHeap.peek();
        } else { // mean of max element from 1st half and min element from 2nd half
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }

    private static void insertIntoHeap(int num, Queue<Integer> minHeap, Queue<Integer> maxHeap) {

        if (!maxHeap.isEmpty() && num < maxHeap.peek()) { // if num fits into 1st half insert into maxHeap
            maxHeap.offer(num);
        } else { // if num fits into 2nd half insert into minHeap
            minHeap.offer(num);
        }
        // balance both heaps after every insertion
        balanceMinMaxHeaps(minHeap, maxHeap);
    }

    private static void findMedian(int[] nums) {
        // maxHeap tracks the maximum element in first half of elements
        // minHeap tracks the minimum element in second half of elements
        Queue<Integer> minHeap, maxHeap;
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        // streaming the numbers
        for (int num : nums) {
            // insert into a suitable heap
            insertIntoHeap(num, minHeap, maxHeap);
            // get the median at this point
            System.out.print(getMedian(minHeap, maxHeap) + ", ");
        }
    }

    public static void main(String[] args) {
        // taking stream of integers
        int[] nums = { 21, 10, 15, 3, 4, 14, 32, 45, 11, 12, 16 };
        findMedian(nums);
    }
}
