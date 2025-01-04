package Precomputation;

import java.util.HashSet;

public class UniqueLength3PalindromeSubsequences {
    private static class Pair {
        public int first;
        public int last;
        
        Pair(int first) {
            this.first = first;
            this.last = -1;
        }
    }
    
    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        int result = 0;

        Pair[] preCount = new Pair[26];
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (preCount[idx] == null)
                preCount[idx] = new Pair(i);
            else preCount[idx].last = i;
        }

        for (Pair pair : preCount) {
            if (pair != null && pair.last != -1) {
                HashSet<Character> unique = new HashSet<>();

                for (int j = pair.first + 1; j < pair.last; j++) {
                    unique.add(s.charAt(j));
                }

                result += unique.size();
            }
        }

        return result;
    }
}
