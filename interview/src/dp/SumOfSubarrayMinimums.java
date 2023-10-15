/**
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package dp;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    private int sumSubarrayMins(int[] arr) {

        int[] dp = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                dp[i] = (i + 1) * arr[i];
            } else {
                int dist = stack.peek();
                dp[i] = dp[dist] + (i - dist) * arr[i];
            }
            stack.push(i);
        }
        int sum = 0;
        int mod = 1000000007;
        for (int i : dp) {
            sum += i;
            sum %= mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(arr));
    }
}
