package Graph;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";

        System.out.println(ladderLength(beginWord, endWord, words));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;

        HashSet<String> isVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        isVisited.add(beginWord);
        queue.add(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i  < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return level;

                for (int j = 0; j < beginWord.length(); j++) {
                    for(int k = 'a'; k <= 'z'; k++){
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if(words.contains(str) && !isVisited.contains(str)){
                            queue.add(str);
                            isVisited.add(str);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}
