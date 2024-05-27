/**
 * author: akhilpathivada
 * time: 26/05/24 10:56
 *
 * https://leetcode.com/problems/hand-of-straights/description/
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
 *
 */
package greedy;

import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {

    private boolean isPossibleDivide(int[] nums, int k) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = map.firstEntry().getKey();
            for (int i = first; i < first + k; ++i) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        int k = 3;
        System.out.println(new DivideArrayInSetsOfKConsecutiveNumbers().isPossibleDivide(nums, k));
    }
}
