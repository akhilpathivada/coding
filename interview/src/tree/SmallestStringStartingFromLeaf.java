/**
 * @author akhilpathivada
 * <p>
 * date : 02/04/24
 * time: 06:03
 *
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/description/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
package tree;

public class SmallestStringStartingFromLeaf {

    private String smallestFromLeaf(TreeNode root, String stringFormedSoFar) {
        // base case
        if (root == null) {
            return "";
        }
        String currentString = (char) ('a' + root.data) + stringFormedSoFar;
        if (root.left == null && root.right == null) {
            return currentString;
        }
        String stringFormedFromLeftSubTree = smallestFromLeaf(root.left, currentString);
        String stringFormedFromRightSubTree = smallestFromLeaf(root.right, currentString);
        if (root.left == null) {
            return stringFormedFromRightSubTree;
        }
        if (root.right == null) {
            return stringFormedFromLeftSubTree;
        }
        return stringFormedFromLeftSubTree.compareTo(stringFormedFromRightSubTree) < 0 ?
                stringFormedFromLeftSubTree :
                stringFormedFromRightSubTree;
    }

    private String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, "");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(root));
    }
}
