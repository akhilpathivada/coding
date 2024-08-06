/**
 * date 06/08/24 17:09
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-time-to-repair-cars/description/
 *
 */
package binarysearch;

import java.util.Arrays;

public class MinimumTimeToRepairCars {

    private boolean canRepair(int[] ranks, long time, int carsToBeRepaired) {
        return Arrays.stream(ranks).mapToLong(rank -> rank).reduce(0, (carsCanBeRepaired, rank) ->
                carsCanBeRepaired + (long) (Math.sqrt((double) time / rank))) >= carsToBeRepaired;
    }

    private long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) 1e14;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRepair(ranks, mid, cars)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        System.out.println(new MinimumTimeToRepairCars().repairCars(ranks, cars));
    }
}
