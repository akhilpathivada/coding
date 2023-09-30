/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N)
 * */
package tree;

import linkedlist.LinkedListNode;

public class ConvertSortedListToBinarySearchTree {

    private TreeNode sortedListToBST(LinkedListNode head, LinkedListNode tail) {
        if (head == tail) {
            return null;
        }
        LinkedListNode slow = head, fast = head;
        // get the middle node of the list
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.data);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

    private TreeNode sortedListToBST(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBST(head, null);
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        TreeNode root = new ConvertSortedListToBinarySearchTree().sortedListToBST(head);
        root.preOrder(root);
    }
}
