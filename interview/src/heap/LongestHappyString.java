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

    private final class Pair {

        private final char ch;

        private int count;

        private Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    private void appendCharacters(StringBuilder sb, Pair pair, int times) {
        sb.append(String.valueOf(pair.ch).repeat(Math.max(0, times)));
        pair.count -= times;
    }

    private String longestDiverseString(int a, int b, int c) {
        final PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);
        final StringBuilder sb = new StringBuilder("dd");
        if (a > 0) {
            maxHeap.add(new Pair('a', a));
        }
        if (b > 0) {
            maxHeap.add(new Pair('b', b));
        }
        if (c > 0) {
            maxHeap.add(new Pair('c', c));
        }
        while (maxHeap.size() > 1) {
            Pair pair1 = maxHeap.poll();
            Pair pair2 = maxHeap.poll();
            appendCharacters(sb, pair1, pair1.count >= 2 ? 2 : 1);
            appendCharacters(sb, pair2, pair2.count >= 2 && pair1.count < pair2.count ? 2 : 1);
            if (pair1.count > 0) {
                maxHeap.add(pair1);
            }
            if (pair2.count > 0) {
                maxHeap.add(pair2);
            }
        }
        if (!maxHeap.isEmpty() && sb.charAt(sb.length() - 1) != maxHeap.peek().ch) {
            Pair pair = maxHeap.poll();
            appendCharacters(sb, pair, pair.count >= 2 ? 2 : 1);
        }
        return sb.substring(2);
    }

    public static void main(String[] args) {
        int a = 2, b = 2, c = 1;
        System.out.println(new LongestHappyString().longestDiverseString(a, b, c));
    }
}
