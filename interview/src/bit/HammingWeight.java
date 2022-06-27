/**
 * https://leetcode.com/problems/number-of-1-bits/
 * */
package bit;

public class HammingWeight {
	private int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			++count;
		}
		return count;
	}
	public static void main(String[] args) {
		int n = 31;
		System.out.println(new HammingWeight().hammingWeight(n));
	}
}
