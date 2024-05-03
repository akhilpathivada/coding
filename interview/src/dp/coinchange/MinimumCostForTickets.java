/**
 * author: akhilpathivada
 * time: 03/05/24 06:32
 *
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 */
package dp.coinchange;

import java.util.Arrays;

public class MinimumCostForTickets {

    private int f(int[] days, int[] costs, int totalDaysToTravel, int day, int daysCanBeCompleted) {
        while (day < totalDaysToTravel && days[day] <= daysCanBeCompleted) {
            ++day;
        }
        if (day >= totalDaysToTravel) {
            return 0;
        }
        int costWhilePickingPass1 = f(days, costs, totalDaysToTravel, day + 1, days[day]) + costs[0];
        int costWhilePickingPass7 = f(days, costs, totalDaysToTravel, day + 1, days[day] + 6) + costs[1];
        int costWhilePickingPass30 = f(days, costs, totalDaysToTravel, day + 1, days[day] + 29) + costs[2];
        return Math.min(costWhilePickingPass1, Math.min(costWhilePickingPass7, costWhilePickingPass30));
    }

    private int memoize(int[] days, int[] costs, int[] dp, int totalDaysToTravel, int day, int daysCanBeCompleted) {
        while (day < totalDaysToTravel && days[day] <= daysCanBeCompleted) {
            ++day;
        }
        if (dp[day] != -1) {
            return dp[day];
        }
        if (day >= totalDaysToTravel) {
            return 0;
        }
        int costWhilePickingPass1 = memoize(days, costs, dp, totalDaysToTravel, day + 1, days[day]) + costs[0];
        int costWhilePickingPass7 = memoize(days, costs, dp, totalDaysToTravel, day + 1, days[day] + 6) + costs[1];
        int costWhilePickingPass30 = memoize(days, costs, dp, totalDaysToTravel, day + 1, days[day] + 29) + costs[2];
        return dp[day] = Math.min(costWhilePickingPass1, Math.min(costWhilePickingPass7, costWhilePickingPass30));
    }

    private int mincostTickets(int[] days, int[] costs) {
        int totalDaysToTravel = days.length;
        // recursive solution
        // return f(days, costs, totalDaysToTravel, 0, 0);

        // memoization
        final int[] dp = new int[days[totalDaysToTravel - 1]];
        Arrays.fill(dp, -1);
        return memoize(days, costs, dp, totalDaysToTravel, 0, 0);
    }

    public static void main(String[] args) {
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
    }
}
