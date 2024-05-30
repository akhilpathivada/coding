/**
 * author: akhilpathivada
 * time: 28/05/24 12:44
 *
 * https://leetcode.com/problems/maximum-gap/description/
 *
 */
package sort;

import java.util.Arrays;
import java.util.Map;

public class MaximumGap {

    private int maximumGap(int[] nums) {
        final int n = Arrays.stream(nums).max().getAsInt();
        final int[] bucket = new int[n + 1];
        for (int num : nums) {
            bucket[num]++;
        }
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (bucket[i] == 0) {
                continue;
            }
            int j = i + 1;
            while (j <= n && bucket[j] == 0) {
                ++j;
            }
            maxDiff = Math.max(maxDiff, j - i);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(new MaximumGap().maximumGap(nums));
    }
}
