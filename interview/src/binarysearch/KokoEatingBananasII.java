/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * Time Complexity: O(log(answer - k)) * O(N)
 * Space Complexity: O(1)
 * */
package binarysearch;

public class KokoEatingBananasII {

    // compute the hours needed to eat all piles
    private int getHoursToEat(int[] piles, int k) {
        int hoursTaken = 0;
        for (int pile : piles) {
            hoursTaken += Math.ceil((double) pile / k);
        }
        return hoursTaken;
    }

    private int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        // the max speed we can go till is the max amount pile we have
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (getHoursToEat(piles, mid) <= h) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 5;
        System.out.println(new KokoEatingBananasII().minEatingSpeed(piles, h));
    }
}
