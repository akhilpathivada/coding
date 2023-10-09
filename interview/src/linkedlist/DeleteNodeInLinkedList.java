/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package linkedlist;

public class DeleteNodeInLinkedList {

    private void deleteNode(LinkedListNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node)
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(4);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(7);
        head.next.next.next.next.next = new LinkedListNode(5);
        new DeleteNodeInLinkedList().deleteNode(head);
    }
}
