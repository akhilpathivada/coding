/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * */

package linkedlist;

public class SwapNodesInPairs {

    private void mergeNodesInReverse(ListNode head1, ListNode head2) {
        ListNode tail = head2;
        while (head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head2.next = head1;
            head1.next = temp2;
            tail = head1;
            head1 = temp1;
            head2 = temp2;
        }
        if (head1 != null) {
            tail.next = head1;
        }
    }

    private void splitAlternatively(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = next != null ? next.next : next;
            current = next;
        }
    }

    private ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        splitAlternatively(head);
        mergeNodesInReverse(head, newHead);
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.createLinkedListFromArray(nums);
        ListNode.printLinkedList(new SwapNodesInPairs().swapPairs(head));
    }
}
