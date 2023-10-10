/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * Time Complexity: O(answer - k) * O(N)
 * Space Complexity: O(1)
 * */
package binarysearch;

public class KokoEatingBananasI {

    // compute the hours needed to eat all piles
    private int getHoursToEat(int[] piles, int k) {
        int hoursTaken = 0;
        for (int pile : piles) {
            hoursTaken += Math.ceil((double) pile / k);
        }
        return hoursTaken;
    }

    private int minEatingSpeed(int[] piles, int h) {
        int totalPiles = 0;
        for (int pile : piles) {
            totalPiles += pile;
        }
        // if there is only one hour :
        // koko need to eat it at speed of totalPiles
        if (h == 1) {
            return totalPiles;
        }
        // take the average time taken to eat all piles
        int k = totalPiles / h;
        while (true) {
            if (getHoursToEat(piles, k) <= h) {
                return k;
            }
            ++k;
        }
    }

    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 5;
        System.out.println(new KokoEatingBananasI().minEatingSpeed(piles, h));
    }
}
