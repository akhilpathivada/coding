/**
 * author: akhilpathivada
 * time: 27/05/24 17:49
 *
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
 *
 */
package greedy;

import java.util.TreeMap;

public class MinimumRoundsToCompleteAllTasks {

    private int minimumRounds(int[] tasks) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int rounds = 0;
        while (!map.isEmpty()) {
            int task = map.firstKey();
            int remaining = map.get(task);
            if (remaining == 1) {
                return -1;
            }
            if (remaining - 3 >= 2 || remaining - 3 == 0) {
                remaining -= 3;
            } else if (remaining - 3 == 1) {
                remaining -= 2;
            } else {
                remaining = 0;
            }
            map.put(task, remaining);
            if (remaining == 0) {
                map.remove(task);
            }
            ++rounds;
        }
        return rounds;
    }

    public static void main(String[] args) {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(new MinimumRoundsToCompleteAllTasks().minimumRounds(tasks));
    }
}
