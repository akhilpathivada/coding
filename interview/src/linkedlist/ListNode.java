/**
 * date 05/08/24 15:15
 *
 * @author akhil.p
 */
package linkedlist;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // printing linked List
    public void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
}