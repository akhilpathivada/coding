/**
 * author: akhilpathivada
 * time: 28/05/24 16:01
 *
 * https://leetcode.com/problems/linked-list-in-binary-tree/description/
 *
 */
package tree;

public class LinkedListInBinaryTree {

    private final class ListNode {

        private final int val;

        private final ListNode next;

        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return (root.data == head.val) && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }

    private boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static void main(String[] args) {

    }
}
