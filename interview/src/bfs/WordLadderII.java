/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * */
package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // convert the word list into a set
        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        // to store the final result
        List<List<String>> result = new ArrayList<>();
        // to store the strings used on the current level
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        // starting level
        int level = 0;
        // steps taken to reach beginWord is always '1'
        queue.add(new ArrayList<>(Collections.singletonList(beginWord)));
        while (!queue.isEmpty()) {
            List<String> vector = queue.poll();
            // erase all words that has been used in the previous levels to transform
            if (vector.size() > level) {
                for (String w : usedOnLevel) {
                    set.remove(w);
                }
            }
            // get the latest word
            String word = vector.get(vector.size() - 1);
            System.out.println("vect " + vector);
            if (word.equals(endWord)) {
                if (result.isEmpty()) {
                    result.add(vector);
                } else if (result.get(0).size() == vector.size()) {
                    result.add(vector);
                }
            }
            // generate all the possibilities with the current word
            for (int i = 0; i < word.length(); ++i) {
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    char[] replacedCharArray = word.toCharArray();
                    // replace the string with character (a -> z)
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        vector.add(replacedWord);
                        queue.add(vector);
                        // mark as visited on this level
                        usedOnLevel.add(replacedWord);
                        vector.remove(vector.size() - 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new WordLadderII().findLadders(beginWord, endWord, Arrays.asList(wordList)));
    }
}
