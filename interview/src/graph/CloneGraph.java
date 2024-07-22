/**
 *
 * https://leetcode.com/problems/clone-graph/
 *
 * */

package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

        private final Map<Integer, Node> map = new HashMap<>(); // tracks the cloned nodes

        private static final class Node {
                
                private int val;

                private List<Node> neighbors;

                public Node(int _val) {
                        val = _val;
                        neighbors = new ArrayList<Node>();
                }
        }

        private Node cloneGraph(Node node) {
                if (node == null) {
                        return null;
                }
                if (map.containsKey(node.val)) { // node is already formed in clone graph
                        return map.get(node.val);
                }
                Node clone = new Node(node.val); // create new node into Clone graph
                map.put(clone.val, clone); // add into map
                node.neighbors.forEach(neighbor -> clone.neighbors.add(cloneGraph(neighbor)));
                return clone;
        }
        
        public static void main(String[] args) {
                // create graph with 4 nodes
                Node[] graph = new Node[4];
                graph[0] = new Node(1);
                graph[1] = new Node(2);
                graph[2] = new Node(3);
                graph[3] = new Node(4);
                // adding neighbors to nodes
                graph[0].neighbors.add(graph[1]);
                graph[0].neighbors.add(graph[2]);
                graph[1].neighbors.add(graph[0]);
                graph[1].neighbors.add(graph[3]);
                graph[2].neighbors.add(graph[0]);
                graph[2].neighbors.add(graph[3]);
                graph[3].neighbors.add(graph[1]);
                graph[3].neighbors.add(graph[2]);
//                System.out.print("Original Graph : "); new Node().DFS(graph[0]);
//                System.out.print("Cloned Graph : "); new Node().DFS(new CloneGraph().cloneGraph(graph[0]));
        }
}