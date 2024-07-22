/**
 * author: akhilpathivada
 * time: 12/06/24 11:34
 *
 * https://leetcode.com/problems/replace-elements-in-an-array/description/
 *
 */
package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ReplaceElementsInAnArray {

    private int[] arrayChange(int[] nums, int[][] operations) {
        final Map<Integer, Integer> numToIndexMap = new HashMap<>();
        IntStream.range(0, nums.length).forEach(i -> numToIndexMap.put(nums[i], i));
        Arrays.stream(operations).forEach(operation -> {
            int index = numToIndexMap.get(operation[0]);
            nums[index] = operation[1];
            numToIndexMap.remove(operation[0]);
            numToIndexMap.put(operation[1], index);
        });
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        System.out.println(Arrays.toString(new ReplaceElementsInAnArray().arrayChange(nums, operations)));
    }
}
