/**
 * author: akhilpathivada
 * time: 06/06/24 09:46
 *
 * https://leetcode.com/problems/seat-reservation-manager/description/
 *
 */
package design;

import java.util.PriorityQueue;

public class SeatReservationManager {

    private final PriorityQueue<Integer> smallestSeat;

    private int lastOccupiedSeat;

    public SeatReservationManager(int n) {
        this.lastOccupiedSeat = 0;
        this.smallestSeat = new PriorityQueue<>();
    }

    public int reserve() {
        return smallestSeat.isEmpty() ? ++lastOccupiedSeat : smallestSeat.poll();
    }

    public void unreserve(int seatNumber) {
        if (lastOccupiedSeat == seatNumber) {
            --lastOccupiedSeat;
        } else {
            smallestSeat.offer(seatNumber);
        }
    }

    public static void main(String[] args) {
        SeatReservationManager seatManager = new SeatReservationManager(5); // Initializes a SeatManager with 5 seats.
        System.out.println(seatManager.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve());    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        System.out.println(seatManager.reserve());    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        System.out.println(seatManager.reserve());    // The available seats are [3,4,5], so return the lowest of them, which is 3.
        System.out.println(seatManager.reserve());    // The available seats are [4,5], so return the lowest of them, which is 4.
        System.out.println(seatManager.reserve());    // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
