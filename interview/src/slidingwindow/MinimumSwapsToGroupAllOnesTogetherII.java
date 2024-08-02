/**
 * date 02/08/24 13:25
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/
 *
 */
package slidingwindow;

import java.util.Arrays;

public class MinimumSwapsToGroupAllOnesTogetherII {

    private int minSwaps(int[] nums) {
        final int n = nums.length;
        final int onesCount = (int) Arrays.stream(nums).filter(num -> num == 1).count();
        final int[] extendedNums = new int[2 * n]; // extending to handle the circular nature
        System.arraycopy(nums, 0, extendedNums, 0, n);
        System.arraycopy(nums, 0, extendedNums, n, n);
        int currentZerosInWindow = 0;
        int minZerosToSwap = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * n; ++i) { // window length = count of ones
            currentZerosInWindow += extendedNums[i] == 0 ? 1 : 0;
            if (i < onesCount) { // first window
                continue;
            }
            currentZerosInWindow -= extendedNums[i - onesCount] == 0 ? 1 : 0;
            minZerosToSwap = Math.min(minZerosToSwap, currentZerosInWindow);
        }
        return minZerosToSwap;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(new MinimumSwapsToGroupAllOnesTogetherII().minSwaps(nums));
    }
}
