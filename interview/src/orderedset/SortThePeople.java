/**
 * author: akhilpathivada
 * time: 22/07/24 07:53
 *
 * https://leetcode.com/problems/sort-the-people/description/
 *
 */
package orderedset;

import java.util.*;
import java.util.stream.IntStream;

public class SortThePeople {

    private String[] sortPeople(String[] names, int[] heights) {
        final TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        IntStream.range(0, names.length).forEach(i -> map.put(heights[i], names[i]));
        return new ArrayList<>(map.values()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        System.out.println(Arrays.toString(new SortThePeople().sortPeople(names, heights)));
    }
}
