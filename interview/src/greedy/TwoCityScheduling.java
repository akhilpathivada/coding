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
        return Arrays.stream(costs, 0, costs.length / 2).mapToInt(cost -> cost[0]).sum() +
                Arrays.stream(costs, costs.length / 2, costs.length).mapToInt(cost -> cost[1]).sum();
    }

    public static void main(String[] args) {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        System.out.println(new TwoCityScheduling().twoCitySchedCost(costs));
    }
}
