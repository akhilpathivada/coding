/**
 * author: akhilpathivada
 * time: 19/05/24 17:23
 */
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestNodesQueriesInBinarySearchTree {

    private void storeInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        storeInorder(root.left, inorder);
        inorder.add(root.data);
        storeInorder(root.right, inorder);
    }

    private List<Integer> search(List<Integer> arr, int key) {
        int mini = -1;
        int maxi = -1;
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);
            if (val == key) {
                return new ArrayList<>(Arrays.asList(val, val));
            } else if (val < key) {
                mini = val;
                low = mid + 1;
            } else {
                maxi = val;
                high = mid - 1;
            }
        }
        return new ArrayList<>(Arrays.asList(mini, maxi));
    }

    private List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root, inorder);
        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            result.add(search(inorder, query));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);
        int[] queries = {2, 5, 16};
        List<Integer> list = Arrays.stream(queries).boxed().collect(Collectors.toList());
        System.out.println(new ClosestNodesQueriesInBinarySearchTree().closestNodes(root, list));
    }
}
