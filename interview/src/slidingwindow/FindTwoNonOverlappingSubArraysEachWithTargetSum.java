/**
 * author: akhilpathivada
 * time: 09/06/24 08:20
 *
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/
 *
 */
package slidingwindow;

import java.util.Arrays;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum {

    private int minSumOfLengths(int[] arr, int target) {
        final int[] mins = new int[3];
        Arrays.fill(mins, Integer.MAX_VALUE);
        int sum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; ++right) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            System.out.println("curr left = " + left);
            if (sum == target) {
                System.out.println("right at = " +right);
                mins[2] = right - left + 1;
                Arrays.sort(mins);
                System.out.println(Arrays.toString(mins));
                left = right + 1;
                sum = 0;
                System.out.println("new left " + left);
            }
        }
        return mins[0] == Integer.MAX_VALUE || mins[1] == Integer.MAX_VALUE ? -1 : mins[0] + mins[1];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,4,3};
        int target = 3;
//        int[] arr = {7,3,4,7};
//        int[] arr = {1, 6, 1};
//        int target = 7;
        System.out.println(new FindTwoNonOverlappingSubArraysEachWithTargetSum().minSumOfLengths(arr, target));
    }
}
