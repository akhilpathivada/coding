/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package linkedlist;

public class ReverseLinkedListBetweenRange {

    private LinkedListNode reverseListForSize(LinkedListNode head, int size) {

        LinkedListNode curr = head;
        LinkedListNode prev = null;
        LinkedListNode nextPtr = null;
        // traverse the elements for the size of the range
        for (int count = 1; curr != null && count <= size; ++count) {
            nextPtr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
        }
        // point the head of the reversed list to the next of ending node (in original list)
        head.next = nextPtr;
        return prev;
    }

    private LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        LinkedListNode dummy = new LinkedListNode();
        dummy.next = head;
        // starting node from where the reversal should start
        LinkedListNode startingNode = dummy;
        // traverse till the node before the starting node
        for (int i = 1; i < left; ++i) {
            startingNode = startingNode.next;
        }
        // point the node before the starting node to head of reversed list
        startingNode.next = reverseListForSize(startingNode.next, right - left + 1);
        // always new head would be next of the dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        int left = 2, right = 4;
        head.printLinkedList(new ReverseLinkedListBetweenRange().reverseBetween(head, left, right));
    }
}
