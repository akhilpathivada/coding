/**
 * author: akhilpathivada
 * time: 12/06/24 11:23
 *
 * https://leetcode.com/problems/finding-the-users-active-minutes/description/
 *
 */
package hashing;

import java.util.*;

public class FindingTheUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        final Map<Integer, Set<Integer>> idToTimesMap = new HashMap<>();
        final int[] result = new int[k];
        for (int[] log : logs) {
            idToTimesMap.computeIfAbsent(log[0], s -> new HashSet<>()).add(log[1]);
        }
        for (Set<Integer> set : idToTimesMap.values()) {
            int uam = set.size();
            result[uam - 1]++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        System.out.println(Arrays.toString(new FindingTheUsersActiveMinutes().findingUsersActiveMinutes(logs, k)));
    }
}
