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
        final ListNode dummyHead = new ListNode(0, head);
        for (ListNode current = dummyHead; current.next != null; ) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = LinkedListUtil.buildLinkedListFromArray(nums);
        LinkedListUtil.printLinkedList((new RemoveLinkedListElements().removeElements(head, val)));
    }
}
