/**
 * https://leetcode.com/problems/power-of-two/
 * */
package math;

public class PowerOfTwo {
	private boolean isPowerOfTwo(int n) {
		if(n <= 0) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}
	public static void main(String[] args) {
		int n = 64;
		System.out.println(new PowerOfTwo().isPowerOfTwo(n));
	}
}
