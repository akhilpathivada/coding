package dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequencePrint {

    private static List<Integer> printLIS(int[] nums, int n) {
        // store longest increasing sequence till that point
        int lis[] = new int[n];
        lis[0] = 1;
        // track the with whom lis formed
        int hash[] = new int[n];
        hash[0] = 0;
        int maxLength = 1;
        for (int i = 1; i < n; ++i) {
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
            maxLength = Math.max(maxLength, lis[i]);
        }
        // get the maximum from lis[]
        int lastIndex = -1;
        for (int i = 0; i < n; ++i) {
            if (lis[i] == maxLength) {
                lastIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("Longest Increasing Subsequence : " + printLIS(nums, nums.length));
    }
}
