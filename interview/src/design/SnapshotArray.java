/**
 * author: akhilpathivada
 * time: 06/06/24 14:54
 *
 * https://leetcode.com/problems/snapshot-array/description/
 *
 */
package design;

import java.util.TreeMap;

public class SnapshotArray {

    private final TreeMap<Integer, Integer>[] snapsToValuesMap;

    private int snap;

    public SnapshotArray(int length) {
        this.snapsToValuesMap = new TreeMap[length];
        this.snap = 0;
        for (int i = 0; i < length; ++i) {
            snapsToValuesMap[i] = new TreeMap<>();
            snapsToValuesMap[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        snapsToValuesMap[index].put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        return snapsToValuesMap[index].floorEntry(snap_id).getValue();
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0, 5);  // Set array[0] = 5
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0, 6);
        System.out.println(snapshotArr.get(0, 0));  // Get the value of array[0] with snap_id = 0, return 5
    }
}
