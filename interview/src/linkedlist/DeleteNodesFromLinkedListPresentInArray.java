/**
 * date 05/08/24 14:59
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
 *
 */
package linkedlist;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesFromLinkedListPresentInArray {

    private ListNode modifiedList(int[] nums, ListNode head) {
        final Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        final ListNode dummy = new ListNode(0, head);
        ListNode current = head;
        ListNode prev = dummy;
        while (current != null) {
            if (set.contains(current.val)) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        int[] nums = {1, 2, 3};
        head = new DeleteNodesFromLinkedListPresentInArray().modifiedList(nums, head);
        // head.printLinkedList(head);
    }
}
