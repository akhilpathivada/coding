/**
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * Time Complexity : O(V + E)
 * Space Complexity : O(V + E)
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

    private void topologicalSortUtil(GraphNode v, boolean[] visited, Stack<Integer> stack) {
        visited[v.label] = true;
        Iterator<GraphNode> iterator = v.neighbours.iterator();
        while (iterator.hasNext()) {
            GraphNode _v = iterator.next();
            // if the node is not visited : recursively call its adjacent nodes
            if (!visited[_v.label]) {
                topologicalSortUtil(_v, visited, stack);
            }
        }
        stack.push(v.label);
    }

    private int[] topologicalSort(GraphNode[] graph) {
        // by default all the vertices are not visited
        boolean[] visited = new boolean[graph.length];
        // stack stores the result
        Stack<Integer> stack = new Stack<>();
        // call the recursive util function to store
        // Topological Sort starting from all vertices one by one
        for (GraphNode v : graph) {
            if (!visited[v.label]) {
                topologicalSortUtil(v, visited, stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

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
            graph[prerequisites[i][1]].addEdge(graph[prerequisites[i][0]]);
        }
        return graph;
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        GraphNode[] graph = formGraph(numCourses, prerequisites);
        return isCycle(graph) ? new int[0] : topologicalSort(graph);
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(numCourses, prerequisites)));
    }
}
