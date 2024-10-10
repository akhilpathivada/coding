/**
 * author: akhilpathivada
 * time: 10/10/24 06:38
 *
 * https://leetcode.com/problems/maximum-width-ramp/description/
 *
 */
package monotonicstack;

import java.util.Stack;

public class MaximumWidthRamp {

    private int maxWidthRamp(int[] nums) {
        final Stack<Integer> stack = new Stack<>();
        int maxWidth = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                maxWidth = Math.max(maxWidth, i - stack.pop());
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(new MaximumWidthRamp().maxWidthRamp(nums));
    }
}
