/**
 * https://leetcode.com/problems/lru-cache/description/
 * */
package design.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoubleLinkedListNode {
        int key;
        int val;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        DoubleLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // maximum capacity of cache
    private int maxCapacity;
    // store references of key in cache
    private Map<Integer, DoubleLinkedListNode> cache;

    DoubleLinkedListNode head = new DoubleLinkedListNode(-1, -1);
    DoubleLinkedListNode tail = new DoubleLinkedListNode(-1, -1);

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(DoubleLinkedListNode newNode) {
        DoubleLinkedListNode temp = head.next;
        newNode.prev = head;
        newNode.next = temp;
        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode prevNode = node.prev;
        DoubleLinkedListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private int get(int key) {
        // found the key in the cache : so remove it from DLL and add it to last
        if (cache.containsKey(key)) {
            DoubleLinkedListNode result = cache.get(key);
            // remove it from cache
            cache.remove(key);
            // delete node from DLL
            deleteNode(result);
            // adds node to the front of DLL
            addNode(result);
            // update the references in cache
            cache.put(key, head.next);
            return result.val;
        }
        return -1;
    }

    private void put(int key, int value) {
        // found the key in the cache : so remove it from cache and DLL
        if (cache.containsKey(key)) {
            DoubleLinkedListNode node = cache.get(key);
            cache.remove(key);
            deleteNode(node);
        }
        // if cache exceeds limit : remove the last
        if (cache.size() == maxCapacity) {
            cache.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        // adds node the front
        addNode(new DoubleLinkedListNode(key, value));
        // update the references in cache
        cache.put(key, head.next);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
