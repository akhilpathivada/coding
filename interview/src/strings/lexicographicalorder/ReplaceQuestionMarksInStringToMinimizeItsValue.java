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

    // Build the final result string, replacing '?' with the least frequent characters
    private String buildResultString(final List<Character> replacementCharacters, final String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            result.append(ch == '?' ? replacementCharacters.remove(0) : ch);
        }
        return result.toString();
    }

    // Generate a list of replacement characters based on character frequencies
    private List<Character> generateReplacementCharacters(final PriorityQueue<CharFrequency> replacementQueue,
                                                          final int[] charFrequencies, final String s) {
        List<Character> replacementCharacters = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '?') { // Replace '?' with characters of lowest frequency
                char character = replacementQueue.poll().character; // The least frequent character
                replacementCharacters.add(character);
                replacementQueue.add(new CharFrequency(character, ++charFrequencies[character - 'a']));
            }
        }
        return replacementCharacters;
    }

    // Build the priority queue (min-heap) for character replacement
    private PriorityQueue<CharFrequency> buildReplacementQueue(final int[] charFrequencies) {
        // Min-heap to prioritize characters with lower frequency and lexicographically smaller
        PriorityQueue<CharFrequency> replacementQueue = new PriorityQueue<>(
                (a, b) -> a.frequency == b.frequency ? a.character - b.character : a.frequency - b.frequency
        );
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            replacementQueue.add(new CharFrequency(ch, charFrequencies[ch - 'a']));
        }
        return replacementQueue;
    }

    // Calculate the frequency of each character in the string, excluding '?'
    private int[] calculateCharFrequencies(final String s) {
        int[] charFrequencies = new int[26];
        for (char ch : s.toCharArray()) {
            if (ch != '?') {
                charFrequencies[ch - 'a']++;
            }
        }
        return charFrequencies;
    }

    private String minimizeStringValue(String s) {
        int[] charFrequencies = calculateCharFrequencies(s);
        PriorityQueue<CharFrequency> replacementQueue = buildReplacementQueue(charFrequencies);
        List<Character> replacementCharacters = generateReplacementCharacters(replacementQueue, charFrequencies, s);
        Collections.sort(replacementCharacters); // Sort replacement characters to maintain lexicographical order
        return buildResultString(replacementCharacters, s);
    }

    public static void main(String[] args) {
//        String s = "a?a?";
        String s = "abcdefghijklmnopqrstuvwxy??";
        System.out.println(new ReplaceQuestionMarksInStringToMinimizeItsValue().minimizeStringValue(s));
    }
}
