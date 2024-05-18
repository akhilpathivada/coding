/**
 * author: akhilpathivada
 * time: 18/05/24 09:47
 *
 * https://leetcode.com/problems/merge-in-between-linked-lists/
 *
 */
package linkedlist;

public class MergeInBetweenLinkedLists {

    private LinkedListNode getNthNode(LinkedListNode current, int n) {
        while (n-- > 0) {
            current = current.next;
        }
        return current;
    }

    private LinkedListNode getTailOfList(LinkedListNode current) {
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public LinkedListNode mergeInBetween(LinkedListNode list1, int a, int b, LinkedListNode list2) {
        LinkedListNode previousNodeOfA = getNthNode(list1, a - 1);
        LinkedListNode nextNodeOfB = getNthNode(list1, b + 1);
        previousNodeOfA.next = list2;
        getTailOfList(list2).next = nextNodeOfB;
        return list1;
    }

    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode(10);
        list1.next = new LinkedListNode(1);
        list1.next.next = new LinkedListNode(13);
        list1.next.next.next = new LinkedListNode(6);
        list1.next.next.next.next = new LinkedListNode(9);
        list1.next.next.next.next.next = new LinkedListNode(5);
        LinkedListNode list2 = new LinkedListNode(1001);
        list2.next = new LinkedListNode(1002);
        list2.next.next = new LinkedListNode(1003);
        int a = 3;
        int b = 4;
        list1 = new MergeInBetweenLinkedLists().mergeInBetween(list1, a, b, list2);
        list1.printLinkedList(list1);
    }
}
