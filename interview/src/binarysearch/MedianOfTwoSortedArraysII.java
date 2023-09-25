/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Time Complexity : O(log (m + n))
 * Space Complexity : O(1)
 */


package binarysearch;

public class MedianOfTwoSortedArraysII {

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            // Swapping to make A smaller
            return findMedianSortedArrays(nums2, nums1);
        }

        int median1 = -1, median2 = -1;
        int count;
        int start = 0;
        int end = n;
        int realMidInMergedArray = (m + n + 1) / 2;

        while (start <= end) {

        }

        // if (m + n) is odd.. median exists at (m + n) / 2 position
        if ((m + n) % 2 == 1) {
            for (count = 0; count <= (m + n) / 2; ++count) {
                if (i != m && j != n) {
                    median1 = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
                } else if (i < m) {
                    median1 = nums1[i++];
                } else {
                    median1 = nums2[j++];
                }
            }
            return median1;
        } else { // if (m + n) is even.. median will be average of ((m + n)/2 - 1) and (m + n) / 2 position elements
            for (count = 0; count <= (m + n) / 2; ++count) {
                median2 = median1;
                if (i != m && j != n) {
                    median1 = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
                } else if (i < m) {
                    median1 = nums1[i++];
                } else {
                    median1 = nums2[j++];
                }
            }
            return (double) (median1 + median2) / 2;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
