/**
 * author: akhilpathivada
 * time: 04/06/24 08:47
 */
package tree.nary;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {

    private List<Integer> dfs(final Node root, final List<Integer> result) {
        if (root != null) {
            for (Node child : root.children) {
                dfs(child, result);
            }
            result.add(root.val);
        }
        return result;
    }

    private List<Integer> postorder(Node root) {
        return dfs(root, new ArrayList<>());
    }

    public static void main(String[] args) {

    }
}
