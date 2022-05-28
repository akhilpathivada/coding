/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(1)
 * */

package misc;

import java.util.Arrays;

public class MinMovesToMakeArrayEqualI {
        
        private static int minMoves(int[] nums) {
                
                int n = nums.length;
                int moves = 0;
                // sort the array
                Arrays.sort(nums);
                // find the median
                int median = (n%2 == 1) ? nums[n/2] : (nums[n/2] + nums[n/2-1]) / 2;
                // calculate operations needed
                // for an element to convert to the median
                for(int num : nums) {
                        moves += Math.abs(median - num);
                }
                return moves;
        }
        
        public static void main(String[] args) {
                
                int[] nums = {1, 10, 2, 9};
                System.out.println("Min. moves = " + minMoves(nums));
        }
}
