/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
package linkedlist;

public class DeleteMiddleNodeOfList {

    private ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(5);
        new DeleteMiddleNodeOfList().deleteMiddle(head);
        head.printLinkedList(head);
    }
}
