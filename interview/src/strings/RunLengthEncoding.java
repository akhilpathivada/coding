/**
 * author: akhilpathivada
 * time: 21/05/24 11:13
 *
 * https://leetcode.com/problems/string-compression/description/
 *
 */
package strings;


import java.util.Arrays;

public class RunLengthEncoding {

    private int compress(char[] chars) {
        int k = 0;
        for (int i = 0; i < chars.length; ) {
            char letter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == letter) {
                ++i;
                ++count;
            }
            chars[k++] = letter;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[k++] = c;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(new RunLengthEncoding().compress(chars));
    }
}
