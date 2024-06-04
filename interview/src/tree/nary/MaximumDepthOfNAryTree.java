/**
 * author: akhilpathivada
 * time: 04/06/24 08:53
 *
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 *
 */
package tree.nary;

public class MaximumDepthOfNAryTree {

    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node children : root.children) {
            depth = Math.max(depth, maxDepth(children));
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
