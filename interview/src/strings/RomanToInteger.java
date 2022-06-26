/**
 * https://leetcode.com/problems/roman-to-integer/
 * */
package strings;

import java.util.HashMap;

public class RomanToInteger {
	private int romanToInt(String s) {
		if (s.length() == 0 || s == null) {
			return -1;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len = s.length();
		int result = map.get(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; --i) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String s = "LVIII";
		System.out.println(new RomanToInteger().romanToInt(s));
	}
}
