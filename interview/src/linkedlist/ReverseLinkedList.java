/**
 * author: akhilpathivada
 * time: 04/10/24 19:59
 *
 * https://leetcode.com/problems/reverse-linked-list/
 *
 */
package linkedlist;

public class ReverseLinkedList {

    private ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createLinkedListFromArray(nums);
        ListNode.printLinkedList(new ReverseLinkedList().reverseList(head));
    }
}
