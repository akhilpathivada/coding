/**
 * date 07/08/24 12:43
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/heaters/description/
 *
 */
package binarysearch;

import java.util.Arrays;

public class Heaters {

    private boolean canWarm(int[] houses, int[] heaters, int radius) {
        int housesWarmed = 0;
        for (int heater : heaters) {
            int warmRangeOnLeft = heater - radius;
            int warmRangeOnRight = heater + radius;
            int i = housesWarmed; // houses warmed till now
            for (; i < houses.length && houses[i] >= warmRangeOnLeft && houses[i] <= warmRangeOnRight; ++i) ;
            housesWarmed = i;
        }
        return housesWarmed >= houses.length;
    }

    private int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low = 0;
        int high = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canWarm(houses, heaters, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4}, heaters = {1, 4};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }
}
