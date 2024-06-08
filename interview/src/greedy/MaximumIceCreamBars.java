/**
 * author: akhilpathivada
 * time: 08/06/24 07:37
 *
 * https://leetcode.com/problems/maximum-ice-cream-bars/description/
 *
 */
package greedy;

import java.util.Arrays;

public class MaximumIceCreamBars {

    private int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;
        for (int i = 0; i < costs.length && coins >= costs[i]; coins -= costs[i], ++bars, ++i) ;
        return bars;
    }

    public static void main(String[] args) {
        int[] costs = {1, 6, 3, 1, 2, 5};
        int coins = 20;
        System.out.println(new MaximumIceCreamBars().maxIceCream(costs, coins));
    }
}
