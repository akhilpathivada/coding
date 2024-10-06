/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package linkedlist;

public class ReverseLinkedListBetweenRange {

    // Reverse a sublist of size `length` starting from the head of the list
    private ListNode reverseSublist(ListNode startNode, int length) {
        ListNode curr = startNode;
        ListNode next = null;
        ListNode prev = null;
        for (int i = 0; curr != null && i < length; ++i) { // Reverse the list for `length` nodes
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        startNode.next = next; // Connect the last node of the reversed sublist to the remainder of the list
        return prev; // Return the new head of the reversed sublist
    }

    private ListNode reverseBetween(ListNode head, int left, int right) {
        final ListNode dummy = new ListNode(0, head);
        ListNode nodeBeforeLeft = dummy; // Node before the `left` node
        for (int i = 1; i < left; ++i) { // Traverse to the node just before the `left` position
            nodeBeforeLeft = nodeBeforeLeft.next;
        }
        nodeBeforeLeft.next = reverseSublist(nodeBeforeLeft.next, right - left + 1); // Reverse the sublist from `left` to `right`
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = LinkedListUtil.buildLinkedListFromArray(nums);
        int left = 2, right = 4;
        LinkedListUtil.printLinkedList(new ReverseLinkedListBetweenRange().reverseBetween(head, left, right));
    }
}
