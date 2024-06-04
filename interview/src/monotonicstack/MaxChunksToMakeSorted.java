/**
 * author: akhilpathivada
 * time: 04/06/24 18:47
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
 *
 */
package monotonicstack;

import java.util.Stack;

public class MaxChunksToMakeSorted {

    private int maxChunksToSorted(int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            int max = num;
            while (!stack.isEmpty() && num < stack.peek()) {
                max = Math.max(max, stack.pop());
            }
            stack.push(max);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));
    }
}
