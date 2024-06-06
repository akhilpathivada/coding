/**
 * author: akhilpathivada
 * time: 05/06/24 20:24
 *
 * https://leetcode.com/problems/online-election/description/
 *
 */
package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OnlineElection {

    private final Map<Integer, Integer> candidateToVotesMap;

    private final TreeMap<Integer, Integer> timeToLeaderMap;

    public OnlineElection(int[] persons, int[] times) {
        this.candidateToVotesMap = new HashMap<>();
        this.timeToLeaderMap = new TreeMap<>();
        int leader = persons[0];
        for (int i = 0; i < persons.length; ++i) {
            int person = persons[i];
            candidateToVotesMap.put(person, candidateToVotesMap.getOrDefault(person, 0) + 1);
            if (candidateToVotesMap.get(person) >= candidateToVotesMap.get(leader)) {
                leader = person;
            }
            timeToLeaderMap.put(times[i], leader);
        }
    }

    public int q(int t) {
        return timeToLeaderMap.get(timeToLeaderMap.floorKey(t));
    }

    public static void main(String[] args) {
        OnlineElection topVotedCandidate = new OnlineElection(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3)); // return 0, At time 3, the votes are [0], and 0 is leading.
        System.out.println(topVotedCandidate.q(12)); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
        System.out.println(topVotedCandidate.q(25)); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
        System.out.println(topVotedCandidate.q(15)); // return 0
        System.out.println(topVotedCandidate.q(24)); // return 0
        System.out.println(topVotedCandidate.q(8)); // return 1
    }
}
