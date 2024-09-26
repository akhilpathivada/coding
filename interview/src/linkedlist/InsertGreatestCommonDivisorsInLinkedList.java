/**
 * author: akhilpathivada
 * time: 25/09/24 18:40
 *
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 *
 */
package linkedlist;

public class InsertGreatestCommonDivisorsInLinkedList {

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current1 = head;
        ListNode current2 = head.next;
        while (current2 != null) {
            ListNode gcdNode = new ListNode(gcd(current1.val, current2.val));
            current1.next = gcdNode;
            gcdNode.next = current2;
            current1 = current2;
            current2 = current2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        head.printLinkedList(new InsertGreatestCommonDivisorsInLinkedList().insertGreatestCommonDivisors(head));
    }
}
