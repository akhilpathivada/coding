/**
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    private boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }
}
