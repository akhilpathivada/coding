/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package linkedlist;

public class DeleteNodeInLinkedList {

    // approach-1
    private void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // approach-2
    private void deleteNode_2(ListNode node) {
        ListNode temp = new ListNode();
        while (node.next != null) {
            node.val = node.next.val;
            temp = node;
            node = node.next;
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(5);
        new DeleteNodeInLinkedList().deleteNode(head);
    }
}
