/**
 * author: akhilpathivada
 * time: 12/06/24 10:09
 *
 * https://leetcode.com/problems/random-pick-index/description/
 *
 */
package hashing;

import java.util.*;

public class RandomPickIndex {

    private final Map<Integer, List<Integer>> map;

    private final Random random;

    public RandomPickIndex(int[] nums) {
        this.map = new HashMap<>();
        this.random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            map.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        final List<Integer> indexes = map.get(target);
        return indexes.get(random.nextInt(indexes.size()));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
        System.out.println(randomPickIndex.pick(3));
    }
}
