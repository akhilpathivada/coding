/**
 *
 * */
package linkedlist;

import java.util.Stack;
import linkedlist.LinkedListNode;

public class ReverseNodesInKGroup {

    private LinkedListNode reverseKGroup(LinkedListNode head, int k) {
        Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode newList = new LinkedListNode(0);
        LinkedListNode newListHead = newList;
        LinkedListNode current = head;
        int i = 0;
        while (current != null) {
            LinkedListNode nextNode = current.next;
            ++i;
            stack.push(current);
            if (i == k) {
                while (!stack.isEmpty()) {
                    LinkedListNode node = stack.pop();
                    node.next = null;
                    newList.next = node;
                    newList = newList.next;
                }
                i = 0;
            }
            current = nextNode;
        }
        LinkedListNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
        }
        newList.next = temp;
        return newListHead.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        int k = 2;
        head = new ReverseNodesInKGroup().reverseKGroup(head, k);
        head.printLinkedList(head);
    }
}
