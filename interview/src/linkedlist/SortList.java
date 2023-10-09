/**
 * https://leetcode.com/problems/sort-list/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N)
 *
 * */

package linkedlist;

public class SortList {

    private LinkedListNode sortList(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode prev = null;
        // cut the list into 2 halves
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // split into 2 halves
        prev.next = null;
        // sort the lists individually
        LinkedListNode list1 = sortList(head);
        LinkedListNode list2 = sortList(slow);
        // merge two sorted lists
        return merge(list1, list2);
    }

    private LinkedListNode merge(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next =  new LinkedListNode(2);
        head.next.next =  new LinkedListNode(3);
        head.next.next.next =  new LinkedListNode(4);
        head.next.next.next.next =  new LinkedListNode(5);
        head = new SortList().sortList(head);
        head.printLinkedList(head);
    }
}
