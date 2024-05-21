/**
 * author: akhilpathivada
 * time: 21/05/24 10:17
 *
 * https://leetcode.com/problems/design-circular-deque/
 *
 */
package design;

public class MyCircularDeque {

    private final int[] deque;

    private final int size;

    private int front;

    private int rear;

    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.size = k;
        this.front = -1;
        this.rear = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1;

        } else {
            --front;
        }
        deque[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            ++rear;
        }
        deque[rear] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            ++front;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            --rear;
        }
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}
