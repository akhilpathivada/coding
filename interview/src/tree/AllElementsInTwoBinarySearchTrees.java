/**
 * author: akhilpathivada
 * time: 12/05/24 17:18
 *
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
 *
 */
package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

    private void getAllElements(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        getAllElements(root.left, result);
        result.add(root.data);
        getAllElements(root.right, result);
    }

    private List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final List<Integer> result = new ArrayList<>();
        getAllElements(root1, result);
        getAllElements(root2, result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(1);
        System.out.println(new AllElementsInTwoBinarySearchTrees().getAllElements(root1, root2));
    }
}
