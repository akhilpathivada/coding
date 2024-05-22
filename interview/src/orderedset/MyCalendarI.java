/**
 * https://leetcode.com/problems/my-calendar-i/description/
 * */
package orderedset;

import java.util.TreeSet;

public class MyCalendarI {

    private final class Pair {

        private final int start;

        private final int end;

        private Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private final TreeSet<Pair> bst;

    public MyCalendarI() {
        bst = new TreeSet<>((a, b) -> a.start - b.start);
    }

    public boolean book(int start, int end) {
        Pair curr = new Pair(start, end);
        Pair prev = bst.floor(curr);
        Pair next = bst.ceiling(curr);
        if ((prev != null && start < prev.end) || (next != null && end > next.start)) {
            return false;
        }
        return bst.add(curr);
    }

    public static void main(String[] args) {
        MyCalendarI myCalendar = new MyCalendarI();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println(myCalendar.book(20, 30)); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
    }
}
