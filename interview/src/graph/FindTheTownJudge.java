/**
 * https://leetcode.com/problems/find-the-town-judge/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package graph;

public class FindTheTownJudge {

    private int findJudge(int n, int[][] trust) {

        int[] inbound = new int[n + 1];
        int[] outbound = new int[n + 1];
        for (int i = 0; i < trust.length; ++i) {
            outbound[trust[i][0]]++;
            inbound[trust[i][1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (outbound[i] == 0 && inbound[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        int n = 3;
        System.out.println(new FindTheTownJudge().findJudge(n, trust));
    }
}
