/**
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 *
 * */
package patternmatch.rollinghash;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDNASequences {

    private List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        return result;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
    }
}
