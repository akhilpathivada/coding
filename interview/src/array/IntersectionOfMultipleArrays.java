/**
 * author: akhilpathivada
 * time: 02/07/24 10:43
 *
 * https://leetcode.com/problems/intersection-of-multiple-arrays/description/
 *
 */
package array;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfMultipleArrays {

    public List<Integer> intersection(int[][] nums) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums).forEach(arr ->
                Arrays.stream(arr).forEach(
                        num -> frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1))
        );
        return new ArrayList<>(frequencyMap.keySet())
                .stream()
                .filter(num -> frequencyMap.get(num) == nums.length)
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        System.out.println(new IntersectionOfMultipleArrays().intersection(nums));
    }
}
