package DynamicProgramming;

// https://leetcode.com/problems/solving-questions-with-brainpower
public class SolvingQuestionsWithBrainpower {
    public static long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];

        for (int i = questions.length-1; i >= 0; i--) {
            int points = questions[i][0];
            int brainPower = questions[i][1];

            long takeIt = points + ((i + brainPower + 1) < questions.length ? dp[i + brainPower+1] : 0);
            long skipIt = dp[i+1];
            dp[i] = Math.max(takeIt, skipIt);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[][] ques = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints(ques));
    }
}
