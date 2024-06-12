/**
 * author: akhilpathivada
 * time: 12/06/24 10:17
 *
 * https://leetcode.com/problems/linked-list-random-node/
 *
 */
package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {

    private final List<LinkedListNode> list;

    private final Random random;

    public LinkedListRandomNode(LinkedListNode head) {
        this.list = new ArrayList<>();
        this.random = new Random();
        for (LinkedListNode current = head; current != null; current = current.next) {
            list.add(current);
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size())).data;
    }
}
