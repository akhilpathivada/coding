/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 *
 */
package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // form a graph based on the given data
        // graphNode contains <managerId, subordinates>
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            graph.computeIfAbsent(manager[i], m -> new ArrayList<>()).add(i);
        }
        // Queue node holds 2 entries: (employeeId, time_taken_to_inform_this_employee)
        final Queue<int[]> queue = new LinkedList<>();
        // head doesn't take any time to inform himself
        queue.offer(new int[]{headID, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int employee = queue.peek()[0];
            int timeTakenToInformSoFar = queue.peek()[1];
            queue.remove();
            // if employee has no subordinates
            if (!graph.containsKey(employee)) {
                continue;
            }
            List<Integer> subordinates = graph.get(employee);
            // let's inform all it's subordinates
            for (int subordinate : subordinates) {
                queue.add(new int[]{subordinate, timeTakenToInformSoFar + informTime[employee]});
            }
            result = Math.max(result, timeTakenToInformSoFar + informTime[employee]);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6, headID = 2;
        int[] manager = { 2, 2, -1, 2, 2, 2 }, informTime = { 0, 0, 1, 0, 0, 0 };
        System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(n, headID, manager, informTime));
    }
}
