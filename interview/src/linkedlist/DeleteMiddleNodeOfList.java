package linkedlist;

public class DeleteMiddleNodeOfList {

    private LinkedListNode getMiddleNodeOfList(LinkedListNode head) {
        LinkedListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void deleteMiddle(LinkedListNode head) {
        LinkedListNode dummy = new LinkedListNode(-1);
        dummy.next = head;
        LinkedListNode middle = getMiddleNodeOfList(dummy);
        LinkedListNode curr = dummy;

        while (curr != null) {
            if (curr.next == middle) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        dummy.next = null;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(4);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(7);
        head.next.next.next.next.next = new LinkedListNode(5);
        new DeleteMiddleNodeOfList().deleteMiddle(head);
        head.printLinkedList(head);
    }
}
