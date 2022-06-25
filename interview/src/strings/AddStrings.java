/**
 * https://leetcode.com/problems/add-strings/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package strings;

public class AddStrings {
	private String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; --i, --j) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		String num1 = "11", num2 = "123";
		System.out.println(new AddStrings().addStrings(num1, num2));
	}
}
