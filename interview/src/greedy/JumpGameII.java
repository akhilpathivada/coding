/**
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package greedy;

public class JumpGameII {

    private int jump(int[] nums) {

        int currFarthestJump = 0; // farthest jumps we can do
        int currEnd = 0; // last jump ends here
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            currFarthestJump = Math.max(currFarthestJump, i + nums[i]);
            if (i == currEnd) {
                ++jumps;
                currEnd = currFarthestJump;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(new JumpGameII().jump(nums));
    }
}
