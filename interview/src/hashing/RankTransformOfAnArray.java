/**
 * author: akhilpathivada
 * time: 02/10/24 07:38
 *
 * https://leetcode.com/problems/rank-transform-of-an-array/description/
 *
 */
package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RankTransformOfAnArray {

    private int[] arrayRankTransform(int[] arr) {
        final int[] rank = Arrays.copyOf(arr, arr.length);
        final Map<Integer, Integer> numberToRankMap = new HashMap<>();
        Arrays.sort(rank);
        Arrays.stream(rank).forEach(num -> numberToRankMap.putIfAbsent(num, numberToRankMap.size() + 1));
        IntStream.range(0, arr.length).forEach(i -> rank[i] = numberToRankMap.get(arr[i]));
        return rank;
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        System.out.println(Arrays.toString(new RankTransformOfAnArray().arrayRankTransform(arr)));
    }
}
