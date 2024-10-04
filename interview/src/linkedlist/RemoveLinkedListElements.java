/**
 * author: akhilpathivada
 * time: 04/10/24 16:28
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 */
package linkedlist;

public class RemoveLinkedListElements {

    private ListNode removeElements(ListNode head, int val) {
        final ListNode dummy = new ListNode(0, head);
        for (ListNode current = dummy; current.next != null; ) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        int val = 6;
        head.printLinkedList(new RemoveLinkedListElements().removeElements(head, val));
    }
}
