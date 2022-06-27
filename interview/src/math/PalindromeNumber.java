/**
 * https://leetcode.com/problems/palindrome-number/
 * */
package math;

public class PalindromeNumber {
	private boolean isPalindrome(int x) {
		if (x < 0 ) {
			return false;
		}
		int t = x;
		int res = 0;
		while (t != 0) {
			res = (res * 10) + (t % 10);
			t /= 10;
		}
		return res == x;
	}
	public static void main(String[] args) {
		int x = 121;
		System.out.println(new PalindromeNumber().isPalindrome(x));
	}
}
