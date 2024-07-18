/**
 * date 18/07/24 12:57
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/two-city-scheduling/description/
 */
package greedy;

import java.util.Arrays;

public class TwoCityScheduling {

    private int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        int cost = 0;
        for (int i = 0; i < costs.length / 2; ++i) {
            cost += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; ++i) {
            cost += costs[i][1];
        }
        return cost;
    }

    public static void main(String[] args) {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        System.out.println(new TwoCityScheduling().twoCitySchedCost(costs));
    }
}
