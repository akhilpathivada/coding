/**
 * date 05/08/24 15:15
 *
 * @author akhil.p
 */
package linkedlist;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // printing linked list
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    // create linked list from the array
    public static ListNode createLinkedListFromArray(int[] nums) {
        ListNode head, current;
        current = head = new ListNode(-1);
        for (int i = 1; i < nums.length; ++i) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }
}