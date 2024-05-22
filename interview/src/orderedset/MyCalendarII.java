/**
 * author: akhilpathivada
 * time: 21/05/24 20:04
 *
 * https://leetcode.com/problems/my-calendar-ii/description/
 *
 */
package orderedset;

import java.util.TreeSet;

public class MyCalendarII {

    private final class Pair {

        private final int start;

        private final int end;

        private Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private final TreeSet<Pair> bst;

    public MyCalendarII() {
        this.bst = new TreeSet<>((a, b) -> a.start - b.start);
    }

    public boolean book(int start, int end) {
        Pair curr = new Pair(start, end);
        System.out.println("curr " + curr.start + ", "+ curr.end);
        Pair prev1 = bst.floor(curr);
        Pair next1 = bst.ceiling(curr);
        Pair prev2 = null;
        Pair next2 = null;
        if (prev1 != null) {
            prev2 = bst.floor(prev1);
            System.out.println("prev1 " + prev1.start + ", "+ prev1.end);
        }
        if (next1 != null) {
            next2 = bst.ceiling(next1);
            System.out.println("next1 " + next1.start + ", "+ next1.end);
        }
        if ((prev2 != null && prev2 != prev1 && start < prev2.end)
                || (next2 != null && next2 != next1 && end > next2.start)) {
            System.out.println("prev2 " + prev2.start + ", "+ prev2.end);
            System.out.println("next2 " + next2.start + ", "+ next2.end);
            return false;
        }
        bst.add(curr);
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII myCalendarTwo = new MyCalendarII();
        System.out.println(myCalendarTwo.book(10, 20)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked.
        System.out.println(myCalendarTwo.book(5, 15));  // return False, The event cannot be booked, because it would result in a triple booking.
        System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
    }
}
