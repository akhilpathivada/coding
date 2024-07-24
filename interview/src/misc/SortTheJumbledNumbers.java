/**
 * author: akhilpathivada
 * time: 24/07/24 08:29
 *
 * https://leetcode.com/problems/sort-the-jumbled-numbers/description/
 *
 */
package misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortTheJumbledNumbers {

    private int convert(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        int result = 0;
        int f = 1;
        while (num > 0) {
            result += mapping[num % 10] * f;
            f *= 10;
            num /= 10;
        }
        return result;
    }

    private int[] sortJumbled(int[] mapping, int[] nums) {
        final int n = nums.length;
        final Integer[] indices = new Integer[n];
        IntStream.range(0, n).forEach(i -> indices[i] = i);
        Arrays.sort(indices, Comparator.comparing(i -> convert(nums[i], mapping)));
        return Stream.of(indices).mapToInt(i -> nums[i]).toArray();
    }

    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(new SortTheJumbledNumbers().sortJumbled(mapping, nums)));
    }
}
