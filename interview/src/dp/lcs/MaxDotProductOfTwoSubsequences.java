/**
 * author: akhilpathivada
 * time: 09/06/24 13:42
 *
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/
 *
 */
package dp.lcs;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {

    private int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    private int f(int[] nums1, int[] nums2, int n1, int n2) {
        if (n1 < 0 || n2 < 0) {
            return 0;
        }
        int skip1 = f(nums1, nums2, n1 - 1, n2);
        int skip2 = f(nums1, nums2, n1, n2 - 1);
        int pick12 = nums1[n1] * nums2[n2] + f(nums1, nums2, n1 - 1, n2 - 1);
        int skip12 = f(nums1, nums2, n1 - 1, n2 - 1);
        return max(skip1, skip2, pick12, skip12);
    }

    private int memoize(int[] nums1, int[] nums2, int n1, int n2, int[][] dp) {
        if (n1 < 0 || n2 < 0) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        int skip1 = memoize(nums1, nums2, n1 - 1, n2, dp);
        int skip2 = memoize(nums1, nums2, n1, n2 - 1, dp);
        int pick12 = nums1[n1] * nums2[n2] + memoize(nums1, nums2, n1 - 1, n2 - 1, dp);
        int skip12 = memoize(nums1, nums2, n1 - 1, n2 - 1, dp);
        return dp[n1][n2] = max(skip1, skip2, pick12, skip12);
    }

    private int maxDotProduct(int[] nums1, int[] nums2) {
        // special case
        int min1 = Arrays.stream(nums1).min().getAsInt();
        int max1 = Arrays.stream(nums1).max().getAsInt();
        int min2 = Arrays.stream(nums2).min().getAsInt();
        int max2 = Arrays.stream(nums2).max().getAsInt();
        if ((max1 < 0 && min2 > 0) || (min1 > 0 && max2 < 0)) {
            return Math.max(max1 * min2, min1 * max2);
        }

        // actual logic
        final int m = nums1.length;
        final int n = nums2.length;
        // recursion
        // return f(nums1, nums2, m - 1, n - 1);

        // memoization
        final int[][] dp = new int[m + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return memoize(nums1, nums2, m - 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};
        System.out.println(new MaxDotProductOfTwoSubsequences().maxDotProduct(nums1, nums2));
    }
}
