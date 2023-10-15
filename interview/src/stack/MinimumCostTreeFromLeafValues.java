/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package stack;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

    private int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int sum = 0;
        for (int a : arr) {
            while (!stack.isEmpty() && stack.peek() <= a) {
                sum += stack.pop() * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 4 };
        System.out.println(new MinimumCostTreeFromLeafValues().mctFromLeafValues(arr));
    }
}
