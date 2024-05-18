/**
 * author: akhilpathivada
 * time: 17/05/24 22:13
 */
package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    private LinkedListNode removeZeroSumSublists(LinkedListNode head) {
        final LinkedListNode dummy = new LinkedListNode(0);
        final Map<Integer, LinkedListNode> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, dummy);
        dummy.next = head;
        for (LinkedListNode current = head; current != null; current = current.next) {
            map.put(prefixSum += current.data, current);
        }
        prefixSum = 0;
        for (LinkedListNode current = dummy; current != null; current = current.next) {
            current.next = map.get(prefixSum += current.data).next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(3);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(-3);
        head.next.next.next.next = new LinkedListNode(-2);
        head.next.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next.next.next = new LinkedListNode(-5);
        head.next.next.next.next.next.next.next.next = new LinkedListNode(1);
        head = new RemoveZeroSumConsecutiveNodesFromLinkedList().removeZeroSumSublists(head);
        head.printLinkedList(head);
    }
}
