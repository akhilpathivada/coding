/**
 * author: akhilpathivada
 * time: 12/06/24 14:13
 *
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/
 *
 */
package linkedlist;

public class MergeNodesInBetweenZeros {

    private LinkedListNode merge(LinkedListNode head) {
        LinkedListNode current = head.next;
        int sum = 0;
        for (; current != null && current.data != 0; sum += current.data, current = current.next) ;
        current.data = sum;
        return current;
    }

    private LinkedListNode mergeNodes(LinkedListNode head) {
        for (LinkedListNode current = head; current.next != null; current = current.next) {
            if (current.next.data != 0) {
                current.next = merge(current);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.next = new LinkedListNode(3);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(0);
        head.next.next.next.next = new LinkedListNode(4);
        head.next.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next.next.next = new LinkedListNode(0);
        head = new MergeNodesInBetweenZeros().mergeNodes(head);
        head.printLinkedList(head);
    }
}
