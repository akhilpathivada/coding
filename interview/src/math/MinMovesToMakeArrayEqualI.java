/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */

package math;

public class MinMovesToMakeArrayEqualI {
        private int minMoves(int[] nums) {
                int min = nums[0];
                for (int x : nums) {
                        min = Math.min(min, x);
                }
                int moves = 0;
                for (int x : nums) {
                        moves += x - min;
                }
                return moves;
        }
        public static void main(String[] args) {
                int[] nums = { 1, 10, 2, 9 };
                System.out.println("Min. moves = " + new MinMovesToMakeArrayEqualI().minMoves(nums));
        }
}
