/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 * */

package dp.fibonacci;

public class ClimbingStairsII {
        private static int climbStairs(int n) {
                // base case
                if (n == 0 || n == 1) {
                        return n;
                }
                int[] temp = new int[n + 1];
                temp[1] = 1;
                temp[2] = 2;
                for (int i = 3; i <= n; ++i) {
                        temp[i] = temp[i - 1] + temp[i - 2];
                }
                return temp[n];
        }
        public static void main(String[] args) {
                int stairs = 5;
                System.out.printf("Total ways a person can reach the Top : %d ", climbStairs(stairs));
        }
}
