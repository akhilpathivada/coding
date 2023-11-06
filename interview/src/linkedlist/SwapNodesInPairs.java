/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */

package linkedlist;

public class SwapNodesInPairs {

    private LinkedListNode swapPairs(LinkedListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode head1 = head;
        LinkedListNode head2 = head.next;
        LinkedListNode current = head;
        // split nodes alternatively
        while (current != null) {
            LinkedListNode nextNode = current.next;
            current.next = nextNode != null ? nextNode.next : nextNode;
            current = nextNode;
        }
        // merge both the lists
        LinkedListNode tail;
        head = tail = head2;
        while (head2 != null) {
            LinkedListNode temp1 = head1.next;
            LinkedListNode temp2 = head2.next;
            head2.next = head1;
            head1.next = temp2;
            tail = head1;
            head1 = temp1;
            head2 = temp2;
        }
        if (head1 != null) {
            tail.next = head1;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        head = new SwapNodesInPairs().swapPairs(head);
        head.printLinkedList(head);
    }
}
