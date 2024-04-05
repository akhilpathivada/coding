/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequencePrint {

    private static List<Integer> printLIS(int[] nums, int n) {
        // store longest increasing sequence till that point
        int lis[] = new int[n];
        // track the with whom lis formed
        int hash[] = new int[n];
        for (int i = 0; i < n; ++i) {
            lis[i] = 1;
            hash[i] = i;
            // iterate over previous elements and check adding current element
            // to its sequence can increase result
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    hash[i] = j;
                }
            }
        }
        // get the maximum from lis[]
        int maxLength = Arrays.stream(lis).max().getAsInt();
        int lastIndexInTheLIS = -1;
        for (int i = 0; i < n; ++i) {
            if (lis[i] == maxLength) {
                lastIndexInTheLIS = i;
            }
        }
        List<Integer> sequence = new ArrayList<>();
        sequence.add(nums[lastIndexInTheLIS]);
        // till we not reach the initialization value
        while (hash[lastIndexInTheLIS] != lastIndexInTheLIS) {
            lastIndexInTheLIS = hash[lastIndexInTheLIS];
            sequence.add(nums[lastIndexInTheLIS]);
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("Longest Increasing Subsequence : " + printLIS(nums, nums.length));
    }
}
