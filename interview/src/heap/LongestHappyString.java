/**
 * author: akhilpathivada
 * time: 14/10/24 08:27
 *
 * https://leetcode.com/problems/longest-happy-string/description/
 *
 */
package heap;

import java.util.PriorityQueue;

public class LongestHappyString {

    private final class CharFrequency {

        private final char character;

        private int frequency;

        private CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharFrequency> charFrequencyQueue = buildCharFrequencyQueue(a, b, c);
        return generateLongestHappyString(charFrequencyQueue);
    }

    // Build a priority queue (max-heap) based on character frequencies
    private PriorityQueue<CharFrequency> buildCharFrequencyQueue(final int countA, final int countB, final int countC) {
        PriorityQueue<CharFrequency> charFrequencyQueue = new PriorityQueue<>((x, y) -> y.frequency - x.frequency);
        if (countA > 0) {
            charFrequencyQueue.add(new CharFrequency('a', countA));
        }
        if (countB > 0) {
            charFrequencyQueue.add(new CharFrequency('b', countB));
        }
        if (countC > 0) {
            charFrequencyQueue.add(new CharFrequency('c', countC));
        }
        return charFrequencyQueue;
    }

    // Build the longest happy string using the character frequency queue
    private String generateLongestHappyString(PriorityQueue<CharFrequency> charFrequencyQueue) {
        StringBuilder sb = new StringBuilder("dd"); // Add a dummy prefix to handle edge cases
        while (charFrequencyQueue.size() > 1) {
            CharFrequency first = charFrequencyQueue.poll();
            CharFrequency second = charFrequencyQueue.poll();
            appendCharacters(sb, first, first.frequency >= 2 ? 2 : 1);
            appendCharacters(sb, second, second.frequency >= 2 && first.frequency < second.frequency ? 2 : 1);
            reAddToQueue(first, charFrequencyQueue);
            reAddToQueue(second, charFrequencyQueue);
        }
        // Append the last character if it's different from the previous
        if (!charFrequencyQueue.isEmpty() && sb.charAt(sb.length() - 1) != charFrequencyQueue.peek().character) {
            CharFrequency pair = charFrequencyQueue.poll();
            appendCharacters(sb, pair, pair.frequency >= 2 ? 2 : 1);
        }
        return sb.substring(2);
    }

    // Append characters to the result and update their frequency
    private void appendCharacters(final StringBuilder sb, final CharFrequency charFrequency, final int times) {
        sb.append(String.valueOf(charFrequency.character).repeat(Math.max(0, times)));
        charFrequency.frequency -= times;
    }

    // Re-add characters back to the queue if there is any frequency left
    private void reAddToQueue(CharFrequency charFrequency, PriorityQueue<CharFrequency> charFrequencyQueue) {
        if (charFrequency.frequency > 0) {
            charFrequencyQueue.add(charFrequency);
        }
    }

    public static void main(String[] args) {
        int a = 2, b = 2, c = 1;
        System.out.println(new LongestHappyString().longestDiverseString(a, b, c));
    }
}
