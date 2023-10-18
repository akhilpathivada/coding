/**
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * */
package design;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private static class MyStack {
        Queue<Integer> q1, q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            // pop elements from q1 and insert to q2
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            // push new element to q1
            q1.add(x);
            // insert back the elements of q2 to q1
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
