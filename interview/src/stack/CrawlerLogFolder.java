/**
 * https://leetcode.com/problems/crawler-log-folder/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package stack;

public class CrawlerLogFolder {
	private int minOperations(String[] logs) {
		int result = 0;
		for (String s : logs) {
			if (s.equals("../")) {
				result = Math.max(0, --result);
			} else if (s.equals("./")) {
				continue;
			} else {
				++result;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
		System.out.println(new CrawlerLogFolder().minOperations(logs));
	}
}
