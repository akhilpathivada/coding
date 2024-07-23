/**
 * date 23/07/24 12:54
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/
 *
 */
package greedy;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    private int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int myPointer = piles.length - 2;
        int bobPointer = 0;
        int myCoins = 0;
        while (bobPointer++ < myPointer) {
            myCoins += piles[myPointer];
            myPointer -= 2;
        }
        return myCoins;
    }

    public static void main(String[] args) {
        int[] piles = {2, 4, 1, 2, 7, 8};
        System.out.println(new MaximumNumberOfCoinsYouCanGet().maxCoins(piles));
    }
}
