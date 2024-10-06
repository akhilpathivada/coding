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
        for (ListNode current = dummy; current.next != null; ) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.buildLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        int[] nums = {1, 2, 3};
        LinkedListUtil.printLinkedList(new DeleteNodesFromLinkedListPresentInArray().modifiedList(nums, head));
    }
}
