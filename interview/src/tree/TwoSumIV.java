/**
 * author: akhilpathivada
 * time: 04/06/24 08:07
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 */
package tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {

    private final Set<Integer> set = new HashSet<>();

    private boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.data)) {
            return true;
        }
        set.add(root.data);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static void main(String[] args) {

    }
}
