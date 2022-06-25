/**
 * https://leetcode.com/problems/integer-to-roman/
 * */
package strings;

public class IntegerToRoman {
	private String intToRoman(int num) {
		if (num < 1 || num > 3999) {
			return "Roman not available";
		}
		String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (num > 0) {
			while (num >= values[i]) {
				num -= values[i];
				result.append(romans[i]);
			}
			++i;
		}
		return result.toString();
	}
	public static void main(String[] args) {
		int num = 58;
		System.out.println(new IntegerToRoman().intToRoman(num));
	}
}
