/**
 * Date 12/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
package linkedlist;

public class AddOneToNumber {

    private ListNode reverse(ListNode head) {
        ListNode current = head, prev = null, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode addOne(ListNode head) {
        ListNode reversedHead = reverse(head);
        ListNode current = reversedHead;
        ListNode prev = null;
        int carry = 1;
        while (current != null) {
            int sum = carry + current.val;
            carry = sum / 10;
            current.val = sum % 10;
            prev = current;
            current = current.next;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return reverse(reversedHead);
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        ListNode head = LinkedListUtil.buildLinkedListFromArray(nums);
        LinkedListUtil.printLinkedList(new AddOneToNumber().addOne(head));
    }
}
