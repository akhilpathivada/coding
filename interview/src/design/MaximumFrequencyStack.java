/**
 * author: akhilpathivada
 * time: 13/06/24 08:36
 *
 * https://leetcode.com/problems/maximum-frequency-stack/description/
 *
 */
package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

    private final Map<Integer, Integer> numToFreqMap;

    private final Map<Integer, Stack<Integer>> freqToNumsStackMap;

    private int maxFreq;

    public MaximumFrequencyStack() {
        this.numToFreqMap = new HashMap<>();
        this.freqToNumsStackMap = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        int freq = numToFreqMap.getOrDefault(val, 0) + 1;
        numToFreqMap.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        freqToNumsStackMap.computeIfAbsent(freq, s -> new Stack<>()).push(val);
    }

    public int pop() {
        Stack<Integer> stack = freqToNumsStackMap.get(maxFreq);
        int top = stack.pop();
        numToFreqMap.put(top, maxFreq - 1);
        if (stack.isEmpty()) {
            --maxFreq;
        }
        return top;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack freqStack = new MaximumFrequencyStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
