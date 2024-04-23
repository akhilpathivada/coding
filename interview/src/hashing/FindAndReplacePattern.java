package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 22/04/24
 * Time 12:04
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 *
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        final List<String> result = new ArrayList<>();
        for (String word : words) {
            final char[] patternToWord = new char[26];
            final char[] wordToPattern = new char[26];
            boolean isMatch = true;
            for (int i = 0; i < pattern.length(); ++i) {
                final char patternChar = pattern.charAt(i);
                final char wordChar = word.charAt(i);
                if (patternToWord[patternChar - 'a'] == 0) {
                    patternToWord[patternChar - 'a'] = wordChar;
                }
                if (wordToPattern[wordChar - 'a'] == 0) {
                    wordToPattern[wordChar - 'a'] = patternChar;
                }
                if (patternToWord[patternChar - 'a'] != wordChar
                        || wordToPattern[wordChar - 'a'] != patternChar) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(new FindAndReplacePattern().findAndReplacePattern(words, pattern));
    }
}
