package Greedy;

import java.util.*;

// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
public class LexicographicallyMinimumStringAfterRemovingStars {

    // I wrote this approach, and it is correct, and 600/602 testcase are getting passed. For the rest, I am getting TLE.
    // That's OK. The second approach solve the TLE problem.
    public static String clearStars_1(String s) {
        StringBuilder sb = new StringBuilder(s);
        Comparator<Integer> customComparator = (a, b) -> {
            char charA = sb.charAt(a);
            char charB = sb.charAt(b);

            if (charA != charB) {
                return Character.compare(charA, charB);
            } else {
                return Integer.compare(b, a);
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(customComparator);

        int itr = 0;
        while (itr < sb.length()) {
            char ch = sb.charAt(itr);
            if (ch == '*') {
                sb.replace(itr, itr+1, "-");
                int idx = pq.poll();
                sb.replace(idx, idx+1, "-");
            } else {
                pq.add(itr);
            }

            itr++;
        }

        for (int i = 0; i < sb.length();) {
            if (sb.charAt(i) == '-') sb.deleteCharAt(i);
            else i++;
        }

        return sb.toString();
    }

    // This approach is correct according to LL compiler. Here we have use extra space and we are also not getting TLE
    public String clearStars_2(String s) {
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character, Deque<Integer>> map = new HashMap<>();
        boolean[] keep = new boolean[n];
        Arrays.fill(keep, true);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                char smallest = pq.poll();
                int indexToRemove = map.get(smallest).removeLast();
                keep[i] = false;               // Remove '*'
                keep[indexToRemove] = false;   // Remove the smallest char
            } else {
                pq.offer(c);
                map.putIfAbsent(c, new ArrayDeque<>());
                map.get(c).add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (keep[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "dk**";
        System.out.println(clearStars_1(s));
    }
}
