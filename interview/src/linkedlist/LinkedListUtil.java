/**
 * author: akhilpathivada
 * time: 06/10/24 17:02
 */
package linkedlist;

public final class LinkedListUtil {

    // Print linked list
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        for (ListNode current = head; current != null; current = current.next) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    // Build a linked list from an integer array
    public static ListNode buildLinkedListFromArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head, current;
        current = head = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }
}
