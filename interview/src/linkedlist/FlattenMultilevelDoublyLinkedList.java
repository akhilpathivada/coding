/**
 * author: akhilpathivada
 * time: 17/05/24 20:40
 *
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 *
 */
package linkedlist;

public class FlattenMultilevelDoublyLinkedList {

    private static final class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    private Node flattenUtil(Node head) {
        Node current = head;
        Node tail = head;
        while (current != null) {
            if (current.child != null) {
                Node headOfTheChildList = current.child;
                Node tailOfTheChildList = flattenUtil(current.child);
                if (current.next != null) {
                    tailOfTheChildList.next = current.next;
                    current.next.prev = tailOfTheChildList;
                }
                current.next = headOfTheChildList;
                headOfTheChildList.prev = current;
                current.child = null;
                current = tailOfTheChildList;
            }
            tail = current;
            current = current.next;
        }
        return tail;
    }

    private Node flatten(Node head) {
            flattenUtil(head);
            return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, null, null, null);
        head.child = new Node(2, null, null, null);
        head.child.child = new Node(3, null, null, null);
        head = new FlattenMultilevelDoublyLinkedList().flatten(head);
        for (Node current = head; current != null; current = current.next) {
            System.out.println(current.val);
        }
    }
}
