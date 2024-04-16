/**
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    private int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        // map stores number and it's frequency
        Map<Integer, Integer> map = new HashMap<>();
        // insert all elements of nums1
        for (int num : nums1) {
            int frequency = map.getOrDefault(num, 0);
            map.put(num, frequency + 1);
        }
        // list to track the intersecting elements : the result
        List<Integer> intersect = new ArrayList<>();
        // for any element in num2, if it exists in map :
        // add to list and reduce it's frequency
        for (int num : nums2) {
            if (map.get(num) != null && map.get(num) > 0) {
                intersect.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        // convert the list into int[]
        return intersect.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5, 4 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersectionOfArrays(nums1, nums2)));
    }
}
