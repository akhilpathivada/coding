/**
 *
 * https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 * */
package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumNumberOfRemovalsToMakeMountainArray {

    private List<Integer> lis(int[] nums, int n) {
        int[] lis = new int[n];
        lis[0] = 1;
        // find the lis
        for (int i = 1; i < n; ++i) {
            lis[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        return Arrays.stream(lis).boxed().collect(Collectors.toList());
    }

    private int minimumMountainRemovals(int[] nums) {

        int n = nums.length;
        // get the lis
        List<Integer> lis = lis(nums, n);
        // get the lds : reverse the lis to get lds
        List<Integer> lds = lis(nums, n);
        Collections.reverse(lds);

        int maxBitonicSubsequenceLength = 0;
        for (int i = 0; i < n; ++i) {
            if (lis.get(i) == 1 || lds.get(i) == 1)
                continue;
            if (lis.get(i) >= 2 && lds.get(i) >= 2) {
                maxBitonicSubsequenceLength = Math.max(maxBitonicSubsequenceLength, lis.get(i) + lds.get(i) - 1);
            }

        }
        return n - maxBitonicSubsequenceLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1,3,1};
        System.out.println(new MinimumNumberOfRemovalsToMakeMountainArray().minimumMountainRemovals(nums));
    }
}
