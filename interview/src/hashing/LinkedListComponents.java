/**
 * author: akhilpathivada
 * time: 12/06/24 13:26
 *
 * https://leetcode.com/problems/linked-list-components/description/
 *
 */
package hashing;

import java.util.*;

public class LinkedListComponents {

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private int numComponents(ListNode head, int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int components = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                ++components;
            }
            head = head.next;
        }
        return components;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        int[] nums = {0, 1, 3};
        System.out.println(new LinkedListComponents().numComponents(head, nums));
    }
}
