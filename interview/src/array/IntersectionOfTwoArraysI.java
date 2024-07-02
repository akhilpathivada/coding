/**
 * author: akhilpathivada
 * time: 02/07/24 09:59
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysI {

    private static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        final Set<Integer> set = new HashSet<>();
        final Set<Integer> intersect = new HashSet<>();
        // insert all elements into set
        Arrays.stream(nums1).forEach(set::add);
        for (int num : nums2) {
            if (set.contains(num)) { // intersection element found
                intersect.add(num);
            }
        }
        return intersect.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionOfArrays(nums1, nums2)));
    }
}
