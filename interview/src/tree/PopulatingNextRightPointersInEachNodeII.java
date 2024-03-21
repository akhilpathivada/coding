/**
 * @author akhilpathivada
 * <p>
 * date : 21/03/24
 * time: 06:11
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

    static private class Node {
        int data;
        Node left, right, next;

        public Node(int _data) {
            this.data = _data;
            this.left = this.right = null;
        }
    }

    private void connect(Node root) {
        // base case
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                curr.next = queue.peek();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        new PopulatingNextRightPointersInEachNodeII().connect(root);
    }
}
