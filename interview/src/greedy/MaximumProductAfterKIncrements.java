/**
 * author: akhilpathivada
 * time: 14/06/24 09:26
 */
package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MaximumProductAfterKIncrements {

    public int maximumProduct(int[] nums, int k) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long product = 1;
        minHeap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        while (k-- > 0) {
            minHeap.add(minHeap.poll() + 1);
        }
        while (!minHeap.isEmpty()) {
            product = (product * minHeap.poll()) % ((int) 1e9 + 7);
        }
        return (int) product;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 3, 2};
        int k = 2;
        System.out.println(new MaximumProductAfterKIncrements().maximumProduct(nums, k));
    }
}
