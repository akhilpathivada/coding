/**
 * https://leetcode.com/problems/jump-game/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package array;

public class JumpGame {

    private boolean canJump(int[] nums) {
        // max. jumps we can do at a particular point
        int maxReachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(new JumpGame().canJump(nums));
    }
}
