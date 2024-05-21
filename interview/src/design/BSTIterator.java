/**
 * author: akhilpathivada
 * time: 21/05/24 16:36
 */
package design;

import tree.TreeNode;

import java.util.Stack;

public class BSTIterator {

    private final Stack<Integer> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        storeInorder(root);
    }

    private void storeInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        storeInorder(root.right);
        stack.add(root.data);
        storeInorder(root.left);
    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
