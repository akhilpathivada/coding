/**
 * author: akhilpathivada
 * time: 03/08/24 17:58
 *
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/
 *
 */
package hashing;

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubarrays {

    private boolean canBeEqual(int[] target, int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; ++i) {
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
        }
        return map.values().stream().noneMatch(i -> i > 0);
    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        System.out.println(new MakeTwoArraysEqualByReversingSubarrays().canBeEqual(target, arr));
    }
}
