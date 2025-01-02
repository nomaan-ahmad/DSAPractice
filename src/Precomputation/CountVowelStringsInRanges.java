package Precomputation;

import java.util.Arrays;

// https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
public class CountVowelStringsInRanges {
    public static void main(String[] args) {
        String [] words = {"bzmxvzjxfddcuznspdcbwiojiqf","mwguoaskvramwgiweogzulcinycosovozppl","uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs","uivcdsboxnraqpokjzaayedf","yalc","bbhlbmpskgxmxosft","vigplemkoni","krdrlctodtmprpxwditvcps","gqjwokkskrb","bslxxpabivbvzkozzvdaykaatzrpe","qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi","siqbezhkohmgbenbkikcxmvz","ddmaireeouzcvffkcohxus","kjzguljbwsxlrd","gqzuqcljvcpmoqlnrxvzqwoyas","vadguvpsubcwbfbaviedr","nxnorutztxfnpvmukpwuraen","imgvujjeygsiymdxp","rdzkpk","cuap","qcojjumwp","pyqzshwykhtyzdwzakjejqyxbganow","cvxuskhcloxykcu","ul","axzscbjajazvbxffrydajapweci"};
        int[][] queries = {{4, 4},{6, 17},{10, 17},{9, 18},{17, 22},{5, 23},{2, 5},{17, 21},{5, 17},{4, 8},{7, 17},{16, 19},{7, 12},{9, 20},{13, 23},{1, 5},{19, 19}};

        System.out.println(Arrays.toString(vowelStrings(words, queries)));
        //System.out.println(vowelPresent(s));
    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];

        int currCount = 0;

        for (int i = 0; i < words.length; i++) {
            currCount += vowelPresent(words[i]);
            prefix[i] = currCount;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            result[i] = prefix[right];
            if (left != 0) result[i] -= prefix[left-1];
        }

        return result;
    }

    private static int vowelPresent(String str) {
        final int n = str.length();

        // first element check
        char ch = str.charAt(0);
        if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) return 0;

        // last element check
        ch = str.charAt(n-1);
        if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) return 0;

        return 1;
    }
}
