/**
 * author: akhilpathivada
 * time: 11/06/24 18:14
 *
 * https://leetcode.com/problems/insertion-sort-list/description/
 *
 */
package sort;

import java.util.List;

public class InsertionSortList {

    private final static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int pivot;
        for (ListNode current = head.next; current != null; current = current.next) {
            pivot = current.val;
            System.out.println(" pivot " + pivot);
            ListNode temp;
            for (temp = head; temp.next != current && temp.val > pivot; temp = temp.next) {
                temp.next.val = temp.val;
            }
            temp.next.val = pivot;
        }
        return head;
    }

    private void print(ListNode head) {
        for (ListNode current = head; current != null; current = current.next) {
            System.out.print(current.val + "->");
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        InsertionSortList obj = new InsertionSortList();
        obj.print(head);
        head = obj.insertionSortList(head);
        obj.print(head);
    }
}
