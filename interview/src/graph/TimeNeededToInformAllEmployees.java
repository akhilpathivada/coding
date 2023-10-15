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
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Form a graph based on the given data
        // graphNode contains <managerId, subordinates>
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int m = manager[i];
            graph.putIfAbsent(m, new ArrayList<>());
            graph.get(m).add(i);
        }
        // List<Integer> holds 2 entries....
        // List(0) -> employeeId
        // List(1) -> time taken to inform this employee
        Queue<List<Integer>> queue = new LinkedList<>();
        // head doesn't take any time to inform himself
        queue.offer(new ArrayList<>(Arrays.asList(headID, 0)));
        int result = 0;
        while (!queue.isEmpty()) {
            List<Integer> e = queue.poll();
            int employee = e.get(0);
            int timeTakenToInform = e.get(1);
            // if employee has no subordinates
            if (!graph.containsKey(employee)) {
                continue;
            }
            List<Integer> subordinates = graph.get(employee);
            for (int subordinate : subordinates) {
                queue.add(new ArrayList<>(Arrays.asList(subordinate, timeTakenToInform + informTime[employee])));
            }
            result = Math.max(result, timeTakenToInform + informTime[employee]);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6, headID = 2;
        int[] manager = { 2, 2, -1, 2, 2, 2 }, informTime = { 0, 0, 1, 0, 0, 0 };
        System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(n, headID, manager, informTime));
    }
}
