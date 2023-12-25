/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 11:57
 *
 * https://leetcode.com/problems/maximum-tastiness-of-candy-basket/description/
 *
 * Time Complexity:  O(N * log(max(arr[]) - min(arr[])))
 * Space Complexity: O(1)
 */
package binarysearch;

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket {

    private boolean canBeTasty(int[] price, int totalCandies, int diff) {
        int soldCandies = 1;
        // the first candy at index-0
        int positionOfTheLastCandy = 0;
        for (int i = 1; i < price.length; ++i) {
            // candy can be tasty
            if (price[i] - price[positionOfTheLastCandy] >= diff) {
                ++soldCandies;
                positionOfTheLastCandy = i;
            }
        }
        return soldCandies >= totalCandies;
    }

    private int maximumTastiness(int[] price, int k) {
        // impossible to sell
        if (k > price.length) {
            return -1;
        }
        Arrays.sort(price);
        // min. possible diff b/w any two candies
        int low = 1;
        // max. possible diff b/w any two candies
        int high = price[price.length - 1] - price[0];
        int maxDiff = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canBeTasty(price, k, mid)) {
                low = mid + 1;
                maxDiff = Math.max(maxDiff, mid);
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] price = { 13, 5, 1, 8, 21, 2 };
        int k = 3;
        System.out.println(new MaximumTastinessOfCandyBasket().maximumTastiness(price, k));
    }
}
