/**
 * author: akhilpathivada
 * time: 07/10/24 06:50
 *
 * https://leetcode.com/problems/design-front-middle-back-queue/description/
 *
 */
package design;

import java.util.LinkedList;

public class FrontMiddleBackQueue {

    private final LinkedList<Integer> queueList;

    public FrontMiddleBackQueue() {
        this.queueList = new LinkedList<>();
    }

    public void pushFront(int val) {
        queueList.addFirst(val);
    }

    public void pushMiddle(int val) {
        queueList.add(queueList.size() / 2, val);
    }

    public void pushBack(int val) {
        queueList.add(queueList.size(), val);
    }

    public int popFront() {
        return queueList.isEmpty() ? -1 : queueList.removeFirst();
    }

    public int popMiddle() {
        return queueList.isEmpty() ? -1 : queueList.remove((queueList.size() - 1) / 2);
    }

    public int popBack() {
        return queueList.isEmpty() ? -1 : queueList.removeLast();
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)
    }
}
