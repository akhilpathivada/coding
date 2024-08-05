package linkedlist;

public class LinkedListNode {

        public int data; // value of node

        public LinkedListNode next; // next pointer

        // default constructor
        public LinkedListNode() {
        
        }

        // initialize a node with value with next pointer as null
        public LinkedListNode(int value) {
                this.data = value;
                this.next = null;
        }

        // initialize a node with value with next pointer
        public LinkedListNode(int value, LinkedListNode next) {
                this.data = value;
                this.next = next;
        }

        // printing Linked List
        public void printLinkedList(LinkedListNode node) {
                while (node != null) {
                        System.out.print(node.data + ", ");
                        node = node.next;
                }
        }

        public int lengthOfLinkedList(LinkedListNode node) {
                int count = 0;
                while (node != null) {
                        ++count;
                        node = node.next;
                }
                return count;
        }
}
