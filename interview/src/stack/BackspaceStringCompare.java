/**
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * */
package stack;

public class BackspaceStringCompare {
	private static String getString(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '#') {
				if (sb.length() != 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public boolean backspaceCompare(String s, String t) {
		return getString(s).equals(getString(t));
	}
	public static void main(String[] args) {
		String s = "ab#c", t = "ad#c";
		System.out.println(new BackspaceStringCompare().backspaceCompare(s, t));
	}
}
