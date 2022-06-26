/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * */
package linkedlist;

public class ConvertBinaryNumberInLinkedListToInteger {
	private int getDecimalValue(LinkedListNode head) {
		int result = 0;
		while (head != null) {
			result = (result * 2) + head.data;
			head = head.next;
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(0);
		head.next.next = new LinkedListNode(1);
		System.out.println(new ConvertBinaryNumberInLinkedListToInteger().getDecimalValue(head));
	}
}
