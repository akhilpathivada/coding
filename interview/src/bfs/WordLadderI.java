/**
 * https://leetcode.com/problems/word-ladder/description/
 *
 * Time Complexity : O(N * M * 26) where N -> no. of words   M -> word length
 * Space Complexity : O(N)
 * */
package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {

    private static final class Pair {
        private final String word;
        private final int steps;

        private Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // convert the word list into a set
        final Set<String> set = new HashSet<>(wordList);
        final Queue<Pair> queue = new LinkedList<>();
        // steps taken to reach beginWord is always '1'
        queue.add(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int steps = queue.peek().steps;
            queue.remove();
            if (word.equals(endWord)) {
                return steps;
            }
            // generate all the possibilities with the current word
            for (int i = 0; i < word.length(); ++i) {
                // replace the every character of string with characters (a -> z)
                for (char c = 'a'; c <= 'z'; ++c) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, c);
                    String replacedWord = sb.toString();
                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new WordLadderI().ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }
}
