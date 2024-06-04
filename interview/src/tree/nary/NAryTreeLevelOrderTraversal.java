/**
 * author: akhilpathivada
 * time: 04/06/24 08:36
 */
package tree.nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {

    private List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        final List<List<Integer>> result = new ArrayList<>();
        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            while (n-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
