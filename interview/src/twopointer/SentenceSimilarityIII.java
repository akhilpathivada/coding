/**
 * author: akhilpathivada
 * time: 06/10/24 13:17
 *
 * https://leetcode.com/problems/sentence-similarity-iii/description/
 *
 */
package twopointer;

public class SentenceSimilarityIII {

    private boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        final String[] s1Words = sentence1.split(" ");
        final String[] s2Words = sentence2.split(" ");
        int s1Start = 0;
        int s1End = s1Words.length - 1;
        int s2Start = 0;
        int s2End = s2Words.length - 1;
        while (s1Start <= s1End && s2Start <= s2End && s1Words[s1Start].equals(s2Words[s2Start])) {
            ++s1Start;
            ++s2Start;
        }
        while (s1End >= s1Start && s2End >= s2Start && s1Words[s1End].equals(s2Words[s2End])) {
            --s1End;
            --s2End;
        }
        return s1Start > s1End || s2Start > s2End;
    }

    public static void main(String[] args) {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println(new SentenceSimilarityIII().areSentencesSimilar(sentence1, sentence2));
    }
}
