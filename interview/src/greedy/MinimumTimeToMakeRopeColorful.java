/**
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * */
package greedy;

public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int cost = 0;
        int start = 0;
        for (int i = 1; i < colors.length(); ++i) {
            if (arr[i] == arr[i - 1]) {
                if (neededTime[i] < neededTime[start]) {
                    cost += neededTime[i];
                } else {
                    cost += neededTime[start];
                    start = i;
                }
            } else {
                start = i;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost(colors, neededTime));
    }
}
