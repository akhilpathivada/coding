package monotonicstack;

import linkedlist.CloneListWithRandomPointerI;
import linkedlist.LinkedListNode;

import java.util.Stack;

/**
 * Date 21/04/24
 * Time 13:14
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 *
 */
public class RemoveNodesFromLinkedList {

    private LinkedListNode removeNodes(final LinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (LinkedListNode current = head; current != null; current = current.next) {
            while (!stack.isEmpty() && current.data > stack.peek()) {
                stack.pop();

            }
            stack.push(current.data);
        }
        if (stack.isEmpty()) {
            return head;
        }
        LinkedListNode resultListHead = new LinkedListNode(stack.pop());
        LinkedListNode resultListNext = resultListHead;
        while (!stack.isEmpty()) {
            resultListHead = new LinkedListNode(stack.pop());
            resultListHead.next = resultListNext;
            resultListNext = resultListHead;
        }
        return resultListHead;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(5);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(13);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(8);
        head = new RemoveNodesFromLinkedList().removeNodes(head);
        head.printLinkedList(head);
    }
}
