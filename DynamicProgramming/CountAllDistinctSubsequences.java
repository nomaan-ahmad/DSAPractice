package DynamicProgramming;

import java.util.HashMap;
public class CountAllDistinctSubsequences {
    public static void main(String[] args) {
        String str1 = "ljmolmti";
        String str2 = "sqapzwbb";
        System.out.println(countDistinctSubsequences(str1));
        System.out.println(countDistinctSubsequences(str2));
    }
    public static int countDistinctSubsequences(String str) {
        final int n = str.length();
        int[] dp = new int[n+1];
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();

        dp[0] = 1;

        int itr = 0;
        while (itr < n) {
            char ch = str.charAt(itr);
            dp[itr+1] = (2 * dp[itr]);

            if (lastOccurrence.containsKey(ch))
                dp[itr+1] -= dp[lastOccurrence.get(ch)-1];

            lastOccurrence.put(ch, itr+1);

            itr++;
        }

        return dp[n];
    }
}
