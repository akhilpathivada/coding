/**
 * author: akhilpathivada
 * time: 18/05/24 09:05
 *
 * https://leetcode.com/problems/design-linked-list/
 *
 */
package design;

public class MyLinkedList {

    private static final class LinkedListNode {

        private final int val;

        private LinkedListNode next;

        private LinkedListNode(int val, LinkedListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private LinkedListNode head;

    private LinkedListNode tail;

    public MyLinkedList() {
        this.head = this.tail = null;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        LinkedListNode current = head;
        while (index-- > 0) {
            current = current.next;
            if (current == null) {
                return -1;
            }
        }
        return current.val;
    }

    public void addAtHead(int val) {
        head = new LinkedListNode(val, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void addAtTail(int val) {
        LinkedListNode node = new LinkedListNode(val, null);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (head == null) {
            return;
        }
        int i = 0;
        LinkedListNode current = head;
        while (i < index - 1 && current.next != null) {
            ++i;
            current = current.next;
        }
        if (i < index - 1) {
            return;
        }
        if (current.next == null) { // case: tail
            addAtTail(val);
            return;
        }
        LinkedListNode node = new LinkedListNode(val, null);
        node.next = current.next;
        current.next = node;
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        int i = 0;
        LinkedListNode current = head;
        while (i < index - 1 && current.next != null) {
            ++i;
            current = current.next;
        }
        if (current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));              // return 3
    }
}