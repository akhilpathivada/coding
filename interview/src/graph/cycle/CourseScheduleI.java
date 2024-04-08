/**
 * https://leetcode.com/problems/course-schedule/description/
 *
 * Time Complexity : O(V + E)
 * Space Complexity : O(V + E)
 */
package graph.cycle;

import graph.GraphNode;

public class CourseScheduleI {

    private boolean isCycleUtil(GraphNode node, boolean[] visited, boolean[] recStack) {

        if (recStack[node.label]) {
            return true;
        }
        if (visited[node.label]) {
            return false;
        }
        // Mark the current node as visited and
        // part of recursion stack
        visited[node.label] = true;
        recStack[node.label] = true;
        for (GraphNode neighbour : node.neighbours) {
            if (isCycleUtil(neighbour, visited, recStack)) {
                return true;
            }
        }
        recStack[node.label] = false;
        return false;
    }

    private boolean isCycle(GraphNode[] graph) {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[graph.length];
        boolean[] recStack = new boolean[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (isCycleUtil(graph[i], visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private GraphNode[] formGraph(int n, int[][] prerequisites) {
        // create graph with vertices of no. of courses
        GraphNode[] graph = new GraphNode[n];
        // creating all the vertices
        for (int i = 0; i < n; ++i) {
            graph[i] = new GraphNode(i);
        }
        // adding all the edges
        for (int i = 0; i < prerequisites.length; ++i) {
            // add an edge to the course
            graph[prerequisites[i][0]].addEdge(graph[prerequisites[i][1]]);
        }
        return graph;
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphNode[] graph = formGraph(numCourses, prerequisites);
        return !isCycle(graph);
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(new CourseScheduleI().canFinish(numCourses, prerequisites));
    }
}
