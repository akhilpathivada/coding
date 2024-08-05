/**
 * date 05/08/24 17:15
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 *
 */
package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class MinimumGeneticMutation {

    private boolean canMutate(String a, String b) {
        return IntStream.range(0, 8).filter(i -> a.charAt(i) != b.charAt(i)).count() == 1;
    }

    private int minMutation(String startGene, String endGene, String[] bank) {
        final Queue<String> queue = new LinkedList<>();
        final Set<String> visited = new HashSet<>();
        int mutations = 0;
        queue.add(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations;
                }
                for (String s : bank) {
                    if (canMutate(currentGene, s) && !visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
            ++mutations;
        }
        return -1;
    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(new MinimumGeneticMutation().minMutation(startGene, endGene, bank));
    }
}
