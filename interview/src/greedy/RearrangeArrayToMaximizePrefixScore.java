/**
 * author: akhilpathivada
 * time: 12/06/24 08:55
 *
 * https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/description/
 *
 */
package greedy;

import java.util.Arrays;

public class RearrangeArrayToMaximizePrefixScore {

    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int score = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            sum += nums[i];
            score += sum > 0 ? 1 : 0;
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 1, -3, 3, -3};
        System.out.println(new RearrangeArrayToMaximizePrefixScore().maxScore(nums));
    }
}
