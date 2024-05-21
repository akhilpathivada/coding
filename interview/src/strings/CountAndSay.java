/**
 * author: akhilpathivada
 * time: 21/05/24 11:47
 *
 * https://leetcode.com/problems/count-and-say/
 *
 */
package strings;

public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder rle = new StringBuilder("1");
        for (int i = 1; i < n; ++i) {
            String s = rle.toString();
            rle = new StringBuilder();
            for (int j = 0; j < s.length(); ) {
                char letter = s.charAt(j);
                int count = 0;
                while (j < s.length() && s.charAt(j) == letter) {
                    ++j;
                    ++count;
                }
                rle.append(count).append(letter);
            }
        }
        return rle.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new CountAndSay().countAndSay(n));
    }
}
