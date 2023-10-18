/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * */
package design;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private static class MyQueue {

        Stack<Integer> s1, s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            // pop elements from s1 and add to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // push new element into s1
            s1.push(x);
            // push back the elements from s2 to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
