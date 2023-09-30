/**
 * https://leetcode.com/problems/gas-station/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package array;

public class GasStation {

    private int canCompleteCircuit(int[] gas, int[] cost) {

        int fuelInTank = 0; // fuel inside our tank
        int totalFuelInTank = 0; // tracks the difference b/w gas & cost
        int start = 0; // final result : starting gas station

        for (int i = 0; i < gas.length; ++i) {
            fuelInTank += gas[i] - cost[i];
            totalFuelInTank += gas[i] - cost[i];
            if (fuelInTank < 0) {
                // reset our tank
                fuelInTank = 0;
                // update the stating gas station
                start = i + 1;
            }
        }
        return totalFuelInTank < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
