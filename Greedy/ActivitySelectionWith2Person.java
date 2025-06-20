package Greedy;

import java.util.Arrays;

public class ActivitySelectionWith2Person {

    public static int maxActivity(int[] start, int[] finish) {
        int alice = 0;
        int bob = 0;
        int maxActivity = 0;

        int[][] activities = new int[finish.length][2];
        for (int i = 0; i < finish.length; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        Arrays.sort(activities, (a,b) -> {
            if (a[1] == b[1])
                return a[0]-b[0];
            return a[1]-b[1];
        });

        for (int[] activity : activities) {
            int activityStart = activity[0];
            int activityEnd = activity[1];

            if (alice <= activityStart && bob <= activityStart) {
                if (alice >= bob) {
                    alice = activityEnd;
                } else bob = activityEnd;
                maxActivity++;
            } else if (alice <= activityStart) {
                alice = activityEnd;
                maxActivity++;
            } else if (bob <= activityStart) {
                bob = activityEnd;
                maxActivity++;
            }
        }

        return maxActivity;
    }

    public static void main(String[] args) {
        int[] start = {1, 4, 2, 6, 6};
        int[] finish = {3, 5, 7, 9, 11};

        System.out.println(maxActivity(start, finish));
    }
}
