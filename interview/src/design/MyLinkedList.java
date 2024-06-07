/**
 * author: akhilpathivada
 * time: 18/05/24 09:05
 *
 * https://leetcode.com/problems/design-linked-list/
 *
 */
package design;

public class MyLinkedList {

    private final class Node {

        private final int val;

        private Node next;

        private Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    private int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        Node current = head;
        while (index-- > 0) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        ++length;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);
        ++length;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == length) {
            addAtTail(val);
            return;
        } else if (index > length) {
            return;
        }
        Node current = head;
        while (--index > 0) {
            current = current.next;
        }
        Node temp = current.next;
        Node newNode = new Node(val);
        current.next = newNode;
        newNode.next = temp;
        ++length;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        --length;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        while (--index > 0) {
            current = current.next;
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