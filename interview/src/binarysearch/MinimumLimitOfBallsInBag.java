/**
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/
 *
 * Time Complexity: O(log(maxPenalty) * N)
 * Space Complexity: O(1)
 * */
package binarysearch;

import java.util.Arrays;

public class MinimumLimitOfBallsInBag {

    private boolean isPossible(int[] nums, int penalty, int maxOperations) {
        int requiredOperations = 0;
        for (int bag : nums) {
            // no. of operations required to bring bag less than or eq to curr assumed penalty
            int x = bag / penalty;
            // if bag is divisible by penalty, need to subtract 1
            if (bag % penalty == 0) {
                --x;
            }
            requiredOperations += x;
        }
        // getting current penalty is possible only if required ops is <= maxOperations
        return requiredOperations <= maxOperations;
    }

    private int minimumSize(int[] nums, int maxOperations) {
        int maxPenalty = Arrays.stream(nums).max().getAsInt();
        int start = 1, end = maxPenalty;
        int minPenalty = maxPenalty;
        // the penalty always exists between 1 and max. size of a bag
        while (start <= end) {
            int penalty = start + (end - start) / 2;
            if (isPossible(nums, penalty, maxOperations)) {
                end = penalty - 1;
                minPenalty = Math.min(minPenalty, penalty);
            } else {
                start = penalty + 1;
            }
        }
        return minPenalty;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 8, 2 };
        int maxOperations = 4;
        System.out.println(new MinimumLimitOfBallsInBag().minimumSize(nums, maxOperations));
    }
}
