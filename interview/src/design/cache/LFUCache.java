/**
 * https://leetcode.com/problems/lfu-cache/description/
 * */
package design.cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class DLLNode {
        int key;
        int value;
        int frequency;
        DLLNode prev;
        DLLNode next;

        DLLNode(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    class DoubleLinkedList {
        int sizeOfList;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList() {
            head = new DLLNode(-1, -1, -1);
            tail = new DLLNode(-1, -1, -1);
            head.next = tail;
            tail.prev = head;
            sizeOfList = 0;
        }

        // adds to the front of the list
        public void addNode(DLLNode currentNode) {
            DLLNode nextNode = head.next;
            currentNode.next = nextNode;
            currentNode.prev = head;
            head.next = currentNode;
            nextNode.prev = currentNode;
            ++sizeOfList;
        }

        // removes at the end of the list
        public void removeNode(DLLNode current) {
            DLLNode prevNode = current.prev;
            DLLNode nextNode = current.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            --sizeOfList;
        }
    }

    // maximum capacity of cache
    private int maxCapacity;
    // current capacity
    private int currentSize;
    // min. frequency of any key so far
    private int minFrequencySoFar;
    // stores (key, node address)
    private Map<Integer, DLLNode> cache;
    // stores (frequency, list of nodes with this frequency)
    private Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currentSize = 0;
        this.minFrequencySoFar = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    private void updateNode(DLLNode currentNode) {
        int currentFrequency = currentNode.frequency;
        DoubleLinkedList currentList = frequencyMap.get(currentFrequency);
        currentList.removeNode(currentNode);
        // if this the last and final of the list
        // increase the minFrequencySoFar
        if (currentFrequency == minFrequencySoFar && currentList.sizeOfList == 0) {
            ++minFrequencySoFar;
        }
        ++currentNode.frequency;
        // if the list if present with this new frequency, update it
        // or create a new list
        DoubleLinkedList newList = frequencyMap.getOrDefault(currentNode.frequency, new DoubleLinkedList());
        newList.addNode(currentNode);
        frequencyMap.put(currentNode.frequency, newList);
    }

    private int get(int key) {
        // not found in the cache
        DLLNode currentNode = cache.get(key);
        if (currentNode == null) {
            return -1;
        }
        updateNode(currentNode);
        return currentNode.value;
    }

    private void put(int key, int value) {
        // corner case
        if (maxCapacity == 0) {
            return;
        }
        // found the key in the cache : so remove it from cache and DLL
        if (cache.containsKey(key)) {
            DLLNode currentNode = cache.get(key);
            currentNode.value = value;
            updateNode(currentNode);
        } else {
            ++currentSize;
            // if cache exceeds limit : remove the lfu
            if (currentSize > maxCapacity) {
                DoubleLinkedList minFrequencyList = frequencyMap.get(minFrequencySoFar);
                DLLNode lfuNode = minFrequencyList.tail.prev;
                cache.remove(lfuNode.key);
                minFrequencyList.removeNode(lfuNode);
                --currentSize;
            }
            // reset the minFrequencySoFar to 1
            minFrequencySoFar = 1;
            // adds node the front
            DLLNode newNode = new DLLNode(key, value, 1);
            // now get the list with frequency 1
            // and add this new node to the list
            DoubleLinkedList currentList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            currentList.addNode(newNode);
            // putting the frequency list
            frequencyMap.put(1, currentList);
            // finally putting the key into the cache
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1); // cache is {1=1}
        lFUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lFUCache.get(1)); // return 1
        lFUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lFUCache.get(2)); // returns -1 (not found)
        lFUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lFUCache.get(1)); // returns -1 (not found)
        System.out.println(lFUCache.get(3));    // return 3
        System.out.println(lFUCache.get(4));    // return 4
    }
}
