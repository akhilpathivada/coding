/**
 * author: akhilpathivada
 * time: 18/06/24 08:08
 *
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 *
 */
package binarysearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    private boolean canFormSuccessfulPair(int spell, int potion, long success) {
        return (long) spell * potion >= success;
    }

    private int[] successfulPairs(int[] spells, int[] potions, long success) {
        final int n = spells.length;
        final int m = potions.length;
        final int[] result = new int[n];
        Arrays.parallelSort(potions);
        for (int i = 0; i < n; ++i) {
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canFormSuccessfulPair(spells[i], potions[mid], success)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        long success = 7;
        System.out.println(Arrays.toString(new SuccessfulPairsOfSpellsAndPotions().successfulPairs(spells, potions, success)));
    }
}
