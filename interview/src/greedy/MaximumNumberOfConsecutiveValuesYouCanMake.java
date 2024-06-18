/**
 * author: akhilpathivada
 * time: 17/06/24 13:42
 *
 * https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/description/
 *
 */
package greedy;

import java.util.Arrays;

public class MaximumNumberOfConsecutiveValuesYouCanMake {

    private int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int result = 1;
        for (int coin : coins) {
            if (result < coin) {
                break;
            }
            result += coin;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] coins = {1, 1, 1, 4};
        System.out.println(new MaximumNumberOfConsecutiveValuesYouCanMake().getMaximumConsecutive(coins));
    }
}
