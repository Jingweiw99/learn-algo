package com.wjw;

public class Lc1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference diff = new Difference(new int[n]);
        for (int[] booking : bookings) {
            diff.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return diff.result();
    }
}
