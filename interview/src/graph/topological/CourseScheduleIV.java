package graph.topological;
/**
 * Date 23/04/24
 * Time 22:26
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/course-schedule-iv/description/
 *
 */
import java.util.*;

public class CourseScheduleIV {

    private List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        final List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }
        final int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        // applying kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        final boolean[][] table = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                // inherit the prerequisite properties of parent
                for (int i = 0; i < numCourses; ++i) {
                    table[neighbor][i] = table[node][i];
                }
                table[neighbor][node] = true;
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        final List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(table[query[0]][query[1]]);
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
