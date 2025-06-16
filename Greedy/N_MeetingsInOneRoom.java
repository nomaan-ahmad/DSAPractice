package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
public class N_MeetingsInOneRoom {
    private static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxMeetings(int[] start, int[] end) {
        List<Meeting> meetings = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        meetings.sort(Comparator.comparingInt(a -> a.end));
        int trackEnd = -1; // initial value

        for (int i = 0; i < start.length; i++) {
            if (trackEnd < meetings.get(i).start) {
                trackEnd = meetings.get(i).end;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(start, end));
    }
}
