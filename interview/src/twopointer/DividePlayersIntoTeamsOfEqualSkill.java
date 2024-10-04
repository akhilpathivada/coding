/**
 * author: akhilpathivada
 * time: 04/10/24 06:25
 *
 * https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
 *
 */
package twopointer;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {

    private long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left = 0;
        int right = skill.length - 1;
        int expectedTeamSkill = skill[left] + skill[right];
        long totalChemistry = 0;
        while (left < right) {
            if (skill[left] + skill[right] != expectedTeamSkill) {
                return -1;
            }
            totalChemistry += (long) skill[left++] * skill[right--];
        }
        return totalChemistry;
    }

    public static void main(String[] args) {
        int[] skill = {3, 2, 5, 1, 3, 4};
        System.out.println(new DividePlayersIntoTeamsOfEqualSkill().dividePlayers(skill));
    }
}
