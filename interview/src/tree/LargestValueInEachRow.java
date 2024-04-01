/**
 * @author akhilpathivada
 * <p>
 * date : 01/04/24
 * time: 10:04
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachRow {

    private List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxValueInCurrentLevel = root.data;
        while (!queue.isEmpty()) {
            result.add(maxValueInCurrentLevel);
            maxValueInCurrentLevel = Integer.MIN_VALUE;
            int sizeOfQueue = queue.size();
            while (sizeOfQueue-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    maxValueInCurrentLevel = Math.max(maxValueInCurrentLevel, node.left.data);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    maxValueInCurrentLevel = Math.max(maxValueInCurrentLevel, node.right.data);
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(new LargestValueInEachRow().largestValues(root));
    }
}
