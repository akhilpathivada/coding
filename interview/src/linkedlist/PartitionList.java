/**
 *
 *  https://leetcode.com/problems/partition-list/description/
 *
 * */
package linkedlist;

public class PartitionList {

    private LinkedListNode partition(LinkedListNode head, int x) {
        LinkedListNode smallerNodesList = new LinkedListNode(0);
        LinkedListNode greaterNodesList = new LinkedListNode(0);
        LinkedListNode smallerNodesListHead = smallerNodesList;
        LinkedListNode greaterNodesListHead = greaterNodesList;
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode nextNode = current.next;
            if (current.data < x) {
                smallerNodesList.next = current;
                current.next = null;
                smallerNodesList = smallerNodesList.next;
            } else {
                greaterNodesList.next = current;
                current.next = null;
                greaterNodesList = greaterNodesList.next;
            }
            current = nextNode;
        }
        smallerNodesList.next = greaterNodesListHead.next;
        return head = smallerNodesListHead.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(4);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(2);
        int x = 3;
        head = new PartitionList().partition(head, x);
        head.printLinkedList(head);
    }
}
