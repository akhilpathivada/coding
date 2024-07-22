/**
 * date 22/07/24 13:11
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 */
package greedy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {

    private String largestNumber(int[] nums) {
        final String[] strs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList())
                .stream()
                .toArray(String[]::new);
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        return strs[0].equals("0") ? "0" : String.join("", strs);
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new LargestNumber().largestNumber(nums));
    }
}
