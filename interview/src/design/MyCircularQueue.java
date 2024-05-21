/**
 * author: akhilpathivada
 * time: 21/05/24 09:57
 *
 * https://leetcode.com/problems/design-circular-queue/description/
 *
 */
package design;

public class MyCircularQueue {

    private final int[] queue;

    private final int size;

    private int front;

    private int rear;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.size = k;
        this.front = -1;
        this.rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % size;
        queue[rear] = value;
        if (front == -1) {
            front = 0;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4

    }
}
