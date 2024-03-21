/**
 * @author akhilpathivada
 * <p>
 * date : 21/03/24
 * time: 05:27
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexty: O(1)
 */
package strings;

public class ReverseWords {

    private String reverseWords(String s) {
        // trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");
        // initialize the output string
        StringBuilder output = new StringBuilder();
        // iterate through the words in the reverse order
        for (int i = str.length - 1; i > 0; --i) {
            // append the current word and a space to the output
            output.append(str[i]).append(" ");
        }
        // append the first word to the output (without trailing space)
        return output + str[0];
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseWords().reverseWords(s));
    }
}
