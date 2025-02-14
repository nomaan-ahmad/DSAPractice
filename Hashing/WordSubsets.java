package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/word-subsets/

public class WordSubsets {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"lo","eo"};

        var result = wordSubsets(words1, words2);
        System.out.println(result);
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        HashMap<Character, Integer> max = new HashMap<>();
        HashMap<Character, Integer> aux;

        for (String words : words2) {
            aux = new HashMap<>();
            for (int i = 0; i < words.length(); i++) {
                char ch = words.charAt(i);
                int val = aux.getOrDefault(ch, 0 ) + 1;
                aux.put(ch, val);
                if (max.getOrDefault(ch, Integer.MIN_VALUE) < val) max.put(ch, val);
            }
        }

        for (String word : words1) {
            aux = new HashMap<>();
            for (Character ch : max.keySet()) aux.put(ch, 0);

            if (isSubset(word, aux, max)) result.add(word);
        }

        return result;
    }

    private static boolean isSubset(String word, HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (map1.containsKey(ch)) {
                int val = map1.get(ch) + 1;

                if (val == map2.get(ch)) map1.remove(ch);
                else map1.put(ch, val);
            }
        }

        return map1.isEmpty();
    }
}
