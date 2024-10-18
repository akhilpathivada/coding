/**
 * author: akhilpathivada
 * time: 18/10/24 09:06
 *
 * https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value/description/
 *
 */
package strings.lexicographicalorder;

import java.util.*;

public class ReplaceQuestionMarksInStringToMinimizeItsValue {

    private final class CharFrequency {

        private final char character;

        private final int frequency;

        private CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    private String minimizeStringValue(String s) {
        int[] charFrequency = new int[26]; // Count the frequency of each character in the string, excluding '?'
        for (char ch : s.toCharArray()) {
            if (ch != '?') {
                charFrequency[ch - 'a']++;
            }
        }
        // Min-heap to prioritize characters with lower frequency and lexicographically smaller
        PriorityQueue<CharFrequency> minHeap = new PriorityQueue<>((a, b) ->
                a.frequency == b.frequency ? a.character - b.character : a.frequency - b.frequency);
        for (char ch = 'a'; ch <= 'z'; ++ch) { // Add all characters and their frequencies to the heap
            minHeap.add(new CharFrequency(ch, charFrequency[ch - 'a']));
        }
        List<Character> replacementCharacters = new ArrayList<>(); // Replace '?' with characters of lowest frequency
        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                char character = minHeap.poll().character; // The least frequent character
                replacementCharacters.add(character);
                minHeap.add(new CharFrequency(character, ++charFrequency[character - 'a']));
            }
        }
        Collections.sort(replacementCharacters); // Sort replacement characters to maintain lexicographical order
        StringBuilder result = new StringBuilder(); // Build the final string by replacing '?' with the chosen characters
        for (char ch : s.toCharArray()) {
            result.append(ch == '?' ? replacementCharacters.remove(0) : ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        String s = "a?a?";
        String s = "abcdefghijklmnopqrstuvwxy??";
        System.out.println(new ReplaceQuestionMarksInStringToMinimizeItsValue().minimizeStringValue(s));
    }
}
