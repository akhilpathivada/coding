/**
 * https://leetcode.com/problems/simplify-path/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */

package stack;

import java.util.Stack;

public class SimplifyPath {

    private String simplifyPath(String path) {
        Stack<String> stack  = new Stack<>();
        // split into tokens
        String[] p = path.split("/");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < p.length; ++i) {
            if (!stack.isEmpty() && p[i].equals("..")) {
                stack.pop();
            } else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) { // if it's a directory
                stack.push(p[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()).insert(0, "/");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String path = "/home//";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }
}
