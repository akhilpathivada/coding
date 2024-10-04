/**
 * author: akhilpathivada
 * time: 04/10/24 19:59
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 */
package linkedlist;

public class ReorderList {

    private void mergeAlternatively(ListNode curr1, ListNode curr2) {
        while (curr2 != null) {
            ListNode next = curr1.next;
            curr1.next = curr2;
            curr1 = curr2;
            curr2 = next;
        }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        /**
         * 1. get middle node of the list
         * 2. middle node will become head of second half list
         * 3. reverse the second half
         * 4. merge both the lists alternatively
         * */
        mergeAlternatively(head, reverse(getMiddleNode(head)));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createLinkedListFromArray(nums);
        new ReorderList().reorderList(head);
        ListNode.printLinkedList(head);
    }
}
