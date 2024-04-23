package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 23/04/24
 * Time 09:00
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 */
public class NAryTreePreorderTraversal {

    private static final class Node {

        public int val;

        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> dfs(final Node root, final List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            for (Node child : root.children) {
                dfs(child, result);
            }
        }
        return result;
    }

    private List<Integer> preorder(Node root) {
        return dfs(root, new ArrayList<>());
    }

    public static void main(String[] args) {

    }
}
