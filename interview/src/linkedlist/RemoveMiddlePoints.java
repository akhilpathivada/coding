/**
 * https://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * */
package linkedlist;

import java.util.List;

public class RemoveMiddlePoints {

    static class ListNode {
        int x, y;
        ListNode next;

        ListNode(int x, int y) {
            this.x = x;
            this.y = y;
            next = null;
        }
    }

    private void remove(ListNode head) {
        ListNode prev = head;
        ListNode temp = head.next;
        while (temp != null) {
            // checking equality of point x
            if (temp.x == prev.x) {
                ListNode curr = prev;
                prev = temp;
                temp = temp.next;
                // removing vertical points of line
                // segment from linked list
                while (temp != null && prev.x == temp.x) {
                    curr.next = temp;
                    prev.next = null;
                    prev = temp;
                    temp = temp.next;
                }
            } else if (temp.y == prev.y) { // checking equality of point y
                ListNode curr = prev;
                prev = temp;
                temp = temp.next;
                // removing horizontal points of line
                // segment from linked list
                while (temp != null && prev.y == temp.y) {
                    curr.next = temp;
                    prev.next = null;
                    prev = temp;
                    temp = temp.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
    }

    private void printPoints(ListNode curr) {
        while (curr != null) {
            System.out.println("(" + curr.x + ", " + curr.y + ")");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(40, 5);
        head.next = new ListNode(20, 5);
        head.next.next = new ListNode(10, 5);
        head.next.next.next = new ListNode(10, 8);
        head.next.next.next.next = new ListNode(10, 10);
        head.next.next.next.next.next = new ListNode(3, 10);
        head.next.next.next.next.next.next = new ListNode(1, 10);
        head.next.next.next.next.next.next.next = new ListNode(0, 10);
        System.out.println("Given List = ");
        new RemoveMiddlePoints().printPoints(head);
        System.out.println("Modified List = ");
        new RemoveMiddlePoints().remove(head);
        new RemoveMiddlePoints().printPoints(head);
    }
}
