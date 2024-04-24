package graph.floydwarshall;

import java.util.*;

/**
 * Date 23/04/24
 * Time 22:26
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/course-schedule-iv/description/
 *
 */
public class CourseScheduleIV {

    private List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // form an adjacency matrix
        final int[][] graph = new int[numCourses][numCourses];
        final int max = Integer.MAX_VALUE / 2;
        for (int[] row : graph) {
            Arrays.fill(row, max);
        }
        for (int[] edge : prerequisites) {
            graph[edge[0]][edge[1]] = 1;
        }
        // apply floyd-warshall algorithm
        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(graph[query[0]][query[1]] != max);
        }
        return result;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[][] queries = {{1, 0}, {0, 1}};
        System.out.println(new CourseScheduleIV().checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}
