/**
 * Date 07/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 *
 * Space Complexity : O(1)
 *
 */
package stack;

import java.util.Stack;

public class SpecialStackForGetMinimum {
        private static int MIN = Integer.MAX_VALUE;

        private static void push(Stack<Integer> stack, int value) {
                if (value > MIN) { // push element if it is bigger than min
                        stack.push(value);
                } else { // update min
                        stack.push(value - MIN);
                        MIN = value;
                }
        }

        private static int pop(Stack<Integer> stack) {
                // base case
                if (stack.isEmpty()) {
                        return -1;
                }
                // if popped element is minimum : update min and pop
                if (stack.peek() <= -1) {
                        int temp = MIN;
                        MIN -= stack.pop();
                        return temp;
                }
                return stack.pop();
        }

        // returns the minimum element
        private static int getMinimum() {
                return MIN;
        }

        public static void main(String[] args) {
                int[] nums = { 3, 2, 6, 1, 8, 5, 5, 5, 5 };
                Stack<Integer> stack = new Stack<>();
                // push elements into stack
                for (int num : nums) {
                        push(stack, num);
                        System.out.println("pushed: "+ num + " and min is: " + MIN);
                }
                // pop all elements from stack and print min every time
                for (int i = 0; i < nums.length; ++i) {
                        System.out.println("popped: "+ pop(stack) + " and min is: " + MIN);
                }
        }
}
