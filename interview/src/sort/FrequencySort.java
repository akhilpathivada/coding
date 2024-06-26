/**
 * author: akhilpathivada
 * time: 26/06/24 18:42
 *
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 *
 */
package sort;

import java.util.*;

public class FrequencySort {

    private int[] frequencySort(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> (map.get(a) == map.get(b)) ? b - a : map.get(a) - map.get(b))
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(new FrequencySort().frequencySort(nums)));
    }
}
