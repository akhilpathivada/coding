/**
 * author: akhilpathivada
 * time: 04/06/24 07:53
 *
 * https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/description/
 *
 */
package greedy;

import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors {

    private int maxConsecutive(int bottom, int top, int[] special) {
        final int n = special.length;
        Arrays.sort(special);
        int maxGap = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; ++i) {
            maxGap = Math.max(maxGap, special[i] - special[i - 1] - 1);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int bottom = 2, top = 9;
        int[] special = {4, 6};
        System.out.println(new MaximumConsecutiveFloorsWithoutSpecialFloors().maxConsecutive(bottom, top, special));
    }
}
