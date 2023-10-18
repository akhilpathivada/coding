///**
// * https://leetcode.com/problems/lfu-cache/description/
// * */
//package design.cache;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;
//
//public class LFUCache {
//    class DoubleLinkedListNode {
//        int key;
//        int val;
//        int freq;
//        DoubleLinkedListNode prev;
//        DoubleLinkedListNode next;
//
//        DoubleLinkedListNode(int key, int val, int freq) {
//            this.key = key;
//            this.val = val;
//            this.freq = freq;
//        }
//    }
//
//    // maximum capacity of design.cache
//    private int maxCapacity;
//    // store references of key in design.cache
//    private Map<Integer, DoubleLinkedListNode> frequencyMap;
//    private Map<Integer, DoubleLinkedListNode> design.cache;
//    // captures the least frequency key
//    private PriorityQueue<List<Integer>> minHeap;
//
//    DoubleLinkedListNode head = new DoubleLinkedListNode(-1, -1);
//    DoubleLinkedListNode tail = new DoubleLinkedListNode(-1, -1);
//
//    public LFUCache(int capacity) {
//        maxCapacity = capacity;
//        design.cache = new HashMap<>();
//        minHeap = new PriorityQueue<>((a, b) -> (a.get(1) - b.get(1)));
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    private void addNode(DoubleLinkedListNode newNode) {
//        DoubleLinkedListNode temp = head.next;
//
//        newNode.prev = head;
//        newNode.next = temp;
//
//        head.next = newNode;
//        temp.prev = newNode;
//    }
//
//
//    private void deleteNode(DoubleLinkedListNode node) {
//        DoubleLinkedListNode prevNode = node.prev;
//        DoubleLinkedListNode nextNode = node.next;
//        prevNode.next = nextNode;
//        nextNode.prev = prevNode;
//    }
//
//    private int get(int key) {
//        // found the key in the design.cache : so remove it from DLL and add it to last
//        if (design.cache.containsKey(key)) {
//            DoubleLinkedListNode result = design.cache.get(key);
//            // remove it from design.cache
//            design.cache.remove(key);
//            // delete node from DLL
//            deleteNode(result);
//            // adds node the front of DLL
//            addNode(result);
//            // update the references in design.cache
//            design.cache.put(key, head.next);
//            return result.val;
//        }
//        return -1;
//    }
//
//    private void put(int key, int value) {
//        // found the key in the design.cache : so remove it from design.cache and DLL
//        if (design.cache.containsKey(key)) {
//            DoubleLinkedListNode node = design.cache.get(key);
//            design.cache.remove(key);
//            deleteNode(node);
//        }
//        // if design.cache exceeds limit : remove the last
//        if (design.cache.size() == maxCapacity) {
//            int lfuKey = minHeap.poll().get(0);
//            DoubleLinkedListNode node = design.cache.get(lfuKey);
//            design.cache.remove(lfuKey);
//            deleteNode(node);
//        }
//        // adds node the front
//        addNode(new DoubleLinkedListNode(key, value));
//        // update the references in design.cache
//        design.cache.put(key, head.next);
////        minHeap.add(Arrays.asList(key, minHeap.poll().get(1) + 1));
//    }
//
//    public static void main(String[] args) {
//        LFUCache lFUCache = new LFUCache(2);
//        lFUCache.put(1, 1); // design.cache is {1=1}
//        lFUCache.put(2, 2); // design.cache is {1=1, 2=2}
//        lFUCache.get(1);    // return 1
//        lFUCache.put(3, 3); // LRU key was 2, evicts key 2, design.cache is {1=1, 3=3}
//        lFUCache.get(2);    // returns -1 (not found)
//        lFUCache.put(4, 4); // LRU key was 1, evicts key 1, design.cache is {4=4, 3=3}
//        lFUCache.get(1);    // return -1 (not found)
//        lFUCache.get(3);    // return 3
//        lFUCache.get(4);    // return 4
//    }
//}
