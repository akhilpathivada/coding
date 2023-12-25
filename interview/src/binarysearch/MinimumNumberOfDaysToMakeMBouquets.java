/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 12:47
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 * https://www.codingninjas.com/studio/problems/rose-garden_2248080
 *
 * Time Complexity:  O(N * log(max(arr[]) - min(arr[])))
 * Space Complexity: O(1)
 */
package binarysearch;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {

    private boolean canMakeMBouquetsOnThisDay(int[] bloomDay, int totalBouquetsToMake, int k, int day) {
        int flowersTaken = 0;
        int numberOfBouquetsCanBeMade = 0;
        // count no. of bouquets we can make on this given day
        for (int i = 0; i < bloomDay.length; ++i) {
            if (bloomDay[i] <= day) { // take the flower: which was bloomed within the given day
                ++flowersTaken;
            } else {
                numberOfBouquetsCanBeMade += (flowersTaken / k);
                flowersTaken = 0;
            }
        }
        numberOfBouquetsCanBeMade += (flowersTaken / k);
        return numberOfBouquetsCanBeMade >= totalBouquetsToMake;
    }

    private int minDays(int[] bloomDay, int m, int k) {
        // impossible case
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        // max. days we need to wait for all the flowers to bloom
        int low = Arrays.stream(bloomDay).min().getAsInt();
        // max. days we need to wait for all the flowers to bloom
        int high = Arrays.stream(bloomDay).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeMBouquetsOnThisDay(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3, k = 1;
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(bloomDay, m, k));
    }
}
