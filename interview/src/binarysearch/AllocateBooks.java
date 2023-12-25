/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 07:57
 *
 * https://www.codingninjas.com/studio/problems/allocate-books_1090540
 *
 * Time Complexity:  O(N * log(sum(arr[]) - max(arr[]) + 1))
 * Space Complexity: O(1)
 */
package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateBooks {

    private int countStudents(ArrayList<Integer> arr, int pages) {
        int students = 1;
        int pagesStudentCanGet = 0;
        for (int i = 0; i < arr.size(); ++i) {
            if (pagesStudentCanGet + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudentCanGet += arr.get(i);
            } else { // add pages to next student
                ++students;
                pagesStudentCanGet = arr.get(i);
            }
        }
        return students;
    }

    private int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n) {
            return -1;
        }
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int n = 4, m = 2;
        System.out.println(new AllocateBooks().findPages(arr, n, m));
    }
}
