/**
 * @author akhilpathivada
 * <p>
 * date : 01/04/24
 * time: 15:27
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class CopyListWithRandomPointer {

    private static class Node {

        private final int val;

        private Node next;

        private Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private void printRandomPointers(Node current) {
        while (current != null) {
            System.out.print("( " + current.val + ", ");
            if (current.random != null) {
                System.out.println(current.random.val + ")");
            }
            current = current.next;
        }
    }

    private Node alternativeSplitList(Node head) {
        Node nodeOfOriginalList = head;
        Node headOfCloneList = head.next;
        while (nodeOfOriginalList != null) {
            Node temp = nodeOfOriginalList.next;
            nodeOfOriginalList.next = temp != null ? temp.next : temp;
            nodeOfOriginalList = temp;
        }
        return headOfCloneList;
    }

    private void setRandomPointers(Node head) {
        Node nodeOfOriginalList = head;
        while (nodeOfOriginalList != null) {
            nodeOfOriginalList.next.random = nodeOfOriginalList.random != null ? nodeOfOriginalList.random.next : null;
            nodeOfOriginalList = nodeOfOriginalList.next.next;
        }
    }

    private void setNextPointers(Node head) {
        // insert clone list nodes at alternate positions into original list
        Node nodeOfOriginalList = head;
        while (nodeOfOriginalList != null) {
            Node nodeOfCloneList = new Node(nodeOfOriginalList.val);
            nodeOfCloneList.next = nodeOfOriginalList.next;
            nodeOfOriginalList.next = nodeOfCloneList;
            nodeOfOriginalList = nodeOfCloneList.next;
        }
    }

    private Node copyRandomList(Node head) {
        setNextPointers(head);
        setRandomPointers(head);
        return alternativeSplitList(head);
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        new CopyListWithRandomPointer().printRandomPointers(head);
        new CopyListWithRandomPointer().printRandomPointers(new CopyListWithRandomPointer().copyRandomList(head));
    }
}
