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
        String[] tokens = path.split("/");
        StringBuilder result = new StringBuilder();
        for (String token : tokens) {
            if (!stack.isEmpty() && token.equals("..")) {
                stack.pop();
            } else if (!token.isEmpty() && !token.equals(".") && !token.equals("..")) { // if it's a directory
                stack.push(token);
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
