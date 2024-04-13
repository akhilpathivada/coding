/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitLinkedListInParts {

    public LinkedListNode[] splitListToParts(LinkedListNode head, int k) {
        int length = 0;
        LinkedListNode current = head;
        // find length of list
        for ( ; current != null; ++length, current = current.next);
        // min. possible size of any part
        int minSizeOfAPart = length / k;
        int extraNodes = length % k;
        List<LinkedListNode> result = new ArrayList<>(k);
        current = head;
        for (int i = 0; i < k; ++i) {
            result.add(current);
            int sizeOfCurrentPart = minSizeOfAPart + (extraNodes-- > 0 ? 1 : 0);
            for (int j = 0; j < sizeOfCurrentPart - 1; ++j) {
                current = current.next;
            }
            if (current != null) {
                LinkedListNode temp = current.next;
                current.next = null;
                current = temp;
            }
        }
        return result.toArray(new LinkedListNode[0]);
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next =  new LinkedListNode(2);
        head.next.next =  new LinkedListNode(3);
        head.next.next.next =  new LinkedListNode(4);
        head.next.next.next.next =  new LinkedListNode(5);
        int k = 3;
        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(head, k)));
    }
}
