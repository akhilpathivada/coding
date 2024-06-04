/**
 * author: akhilpathivada
 * time: 04/06/24 08:48
 */
package tree.nary;

import java.util.List;

public final class Node {

    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
