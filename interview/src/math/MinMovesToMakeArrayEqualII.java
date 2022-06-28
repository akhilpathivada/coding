/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * Time Complexity : O(N * log(N)) -> Sorting
 * Space Complexity : O(N) -> Sorting
 * */

package math;

import java.util.Arrays;

public class MinMovesToMakeArrayEqualII {
        private int minMoves(int[] nums) {
                int n = nums.length;
                // sort the array
                Arrays.sort(nums);
                // find the median
                int median = (n % 2 == 1) ? nums[n / 2] : (nums[n / 2] + nums[n / 2 - 1]) / 2;
                // calculate operations needed
                int i = 0, j = nums.length - 1;
                int moves = 0;
                for (int x : nums){
                        moves += Math.abs(x - median);
                }
                return moves;
        }
        
        public static void main(String[] args) {
                int[] nums = { 1, 10, 2, 9 };
                System.out.println("Min. moves = " + new MinMovesToMakeArrayEqualII().minMoves(nums));
        }
}
