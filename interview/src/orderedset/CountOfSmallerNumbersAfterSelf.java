/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 * */
package orderedset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class CountOfSmallerNumbersAfterSelf {

    private int indexOf(TreeSet<Integer> set, int element) {
        // Step 1: Convert TreeSet to ArrayList
        List<Integer> list = new ArrayList<>(set);
        // Step 2: Use the indexOf method of the List
        System.out.println(list);
        return list.indexOf(element);
    }

    private List<Integer> countSmaller(int[] nums) {
        final TreeSet<Integer> bst = new TreeSet<>();
        final List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            bst.add(nums[i]);
            result.add(0, indexOf(bst, nums[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 5, 6, 1};
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
    }
}
