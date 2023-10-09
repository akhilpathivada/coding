/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package strings;

public class ReverseVowels {

    private String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0, end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while (start < end){
            while (start < end && vowels.indexOf(word[start]) == -1) {
                ++start;
            }
            while (start < end && vowels.indexOf(word[end]) == -1) {
                --end;
            }
            // swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            // Move the pointers towards each other
            ++start;
            --end;
        }
        return new String(word);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new ReverseVowels().reverseVowels(s));
    }
}
