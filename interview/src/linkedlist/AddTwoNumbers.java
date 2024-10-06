/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
package linkedlist;

public class AddTwoNumbers {

    private ListNode addNumbers(ListNode l1, ListNode l2) {
        final ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // Initialize carry to 0
        while (l1 != null || l2 != null || carry == 1) { // Continue the loop while there are nodes in l1, l2, or there is a carry
            int sum = carry; // Start with the carry from the previous iteration
            if (l1 != null) { // Add the value from l1 if it's not null
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // Add the value from l2 if it's not null
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10; // Update carry for the next iteration
            current.next = new ListNode(sum % 10);  // Add the digit to the result list
            current = current.next; // Move the pointer to the next node in the result list
        }
        return dummyHead.next; // Return the next of dummyHead, as it's the actual head of the result
    }

    public static void main(String[] args) {
        ListNode list1 = LinkedListUtil.buildLinkedListFromArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode list2 = LinkedListUtil.buildLinkedListFromArray(new int[]{9, 9, 9, 9});
        LinkedListUtil.printLinkedList(new AddTwoNumbers().addNumbers(list1, list2));
    }
}
