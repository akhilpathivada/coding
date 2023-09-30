/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class StartNodeOfCycleII {
        private static int getStartNodeOfCycle(LinkedListNode head, LinkedListNode nodeInCycle) {
                // if there is no cycle
                if (nodeInCycle == null) {
                        return -1;
                }
                // point slow pointer to head and fast to node in cycle
                LinkedListNode slow, fast;
                slow = head;
                fast = nodeInCycle;
                // intersection point of both pointers should be the start node of cycle
                while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                }
                return slow.data;
        }

        private static LinkedListNode getNodeInCycle(LinkedListNode head) {
                // point both slow, fast pointers to head
                LinkedListNode slow, fast;
                slow = fast = head;
                // slow is a walker, whereas fast is a runner
                while (fast != null && fast.next != null) {
                        slow = slow.next;
                        fast = fast.next.next;
                        // cycle is found
                        if (slow == fast) {
                                return slow;
                        }
                }
                return null;
        }

        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                head.next.next.next.next.next.next = head.next;
                System.out.println(new StartNodeOfCycleII().getStartNodeOfCycle(head,
                        new StartNodeOfCycleII().getNodeInCycle(head)));
        }
}
