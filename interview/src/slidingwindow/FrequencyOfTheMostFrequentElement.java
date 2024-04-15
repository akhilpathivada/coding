package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 14/04/24
 * Time 19:05
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FrequencyOfTheMostFrequentElement {

    private int maxFrequency(int[] nums, int k) {
        int left = 0;
        int operations = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int right = 0; right < nums.length; ++right) {

        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int k = 5;
        System.out.println(new FrequencyOfTheMostFrequentElement().maxFrequency(nums, k));
    }
}
