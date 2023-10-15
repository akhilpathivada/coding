/**
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    private int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; ++i) {
            // if a greater element encountered : pop elements smaller to it
            // and make this current element as their NGE
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                nge[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));
    }
}
