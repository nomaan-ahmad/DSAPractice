package Greedy;

import java.util.Stack;

// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string
public class UsingRoboToPrintTheLexicographicallySmallestString {
    public static String robotWithString(String s) {
        StringBuilder result = new StringBuilder();

        int[] frq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frq[s.charAt(i) - 'a']++;
        }

        Stack<Character> stk = new Stack<>();
        int itr = 0;
        for (int j = 0; j < frq.length;) {
            if (frq[j] != 0) {
                char target = (char) ('a' + j);

                while (!stk.isEmpty() && stk.peek() <= target) {
                    result.append(stk.pop());
                }

                while (itr < s.length()) {
                    char ch = s.charAt(itr);
                    frq[ch - 'a']--;
                    itr++;

                    if (ch == target) {
                        result.append(ch);
                        break;
                    }
                    else stk.add(ch);
                }
            }

            if (frq[j] == 0) j++;
        }

        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "vzhofnpo";
        System.out.println(robotWithString(str));
    }
}
