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
        int[] nums = {3, 2, 4, 2, 7, 5};
        ListNode head = LinkedListUtil.buildLinkedListFromArray(nums);
        new DeleteNodeInLinkedList().deleteNode(head);
        LinkedListUtil.printLinkedList(head);
    }
}
