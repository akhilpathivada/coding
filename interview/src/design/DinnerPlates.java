/**
 * author: akhilpathivada
 * time: 06/06/24 11:22
 *
 * https://leetcode.com/problems/dinner-plate-stacks/
 *
 */
package design;

import java.util.*;

public class DinnerPlates {

    private final Map<Integer, Stack<Integer>> stacks;

    private final int capacity;

    private int first;

    private int last;

    public DinnerPlates(int capacity) {
        this.stacks = new HashMap<>();
        this.capacity = capacity;
        this.first = 0;
        this.last = 0;
        this.stacks.put(first, new Stack<>());
    }

    public void push(int val) {
        // find first available stack
        while (stacks.containsKey(first) && stacks.get(first).size() == capacity) {
            ++first;
        }
        if (!stacks.containsKey(first)) {
            stacks.put(first, new Stack<>());
        }
        stacks.get(first).push(val);
        last = Math.max(last, first);
    }

    public int pop() {
        if (stacks.isEmpty()) {
            return -1;
        }
        while (last >= 0 && stacks.get(last).isEmpty()) {
            --last;
        }
        if (last < 0) {
            return -1;
        }
        first = Math.min(first, last);
        return stacks.get(last).pop();
    }

    public int popAtStack(int index) {
        if (!stacks.containsKey(index) || stacks.get(index).isEmpty()) {
            return -1;
        }
        first = Math.min(first, index);
        return stacks.get(index).pop();
    }

    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(2);  // Initialize with capacity = 2
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
    }
}
