/**
 * date 31/07/24 18:13
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
 *
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinimumConsecutiveCardsToPickUp {

    private int minimumCardPickup(int[] cards) {
        final Map<Integer, Integer> map = new HashMap<>(); // holds <num, freq>
        int left = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < cards.length; ++right) {
            map.put(cards[right], map.getOrDefault(cards[right], 0) + 1);
            while (map.get(cards[right]) > 1) {
                result = Math.min(result, right - left + 1);
                map.put(cards[left], map.get(cards[left++]) - 1);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[] cards = {3, 4, 2, 3, 4, 7};
        System.out.println(new MinimumConsecutiveCardsToPickUp().minimumCardPickup(cards));
    }
}
