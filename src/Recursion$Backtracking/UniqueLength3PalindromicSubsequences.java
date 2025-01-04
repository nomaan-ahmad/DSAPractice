package Recursion$Backtracking;

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/

import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("nnbdimlpnipezthivnshvjrzpusramzuupspeqqvdraycaidrkuxwtbdfirniexijusqspegofzhhfsijyuhdrjzvyuhhsjlgmfoysdqpgrnqbkscuaoykywmfziqxconsyxewexzkmyzywaoczhzomywmfcelgetuotewxvncredigggtyhsaqsbdhknxsidxhpfddtpkomnrfgtwclscobonodindfpcnvlnlbmuskvtpbibzybyakttzqkzjwxjrroqjennsfaahronvgjhyscvktwafcapsbtkgfwbnhvtiprihdrfhbywxqlmzyruikdjtmwhsuxozodgfqxwcsegrpwetsomwiyayzdzmgpfxoujnjgnmczmvxjkofdgypkdijvmrrgvzqmeuesmxoqbawyrtkvgsanjqrqmmaoanhzavruxccdenvgkjkozfrwqwtcjobaemluowcnbfwxmbbyxoayiyptskcegvkxitdzsnzblvitykuahzmjylrrcquscesqticaijhdelokajcpikhkcxxzoejdhmblkmbggqpfchyiquiivwzdiyfizzhsmogjvkcoporoymslhsvukmqgrsubzmknxroujxnqctrjqbzrktzlagnnpolkupniackzdydilfmmlsihvcwqrezgeeoygkeqlapfpksftvbcweilgwnqpppjvqvshpcddhes"));
    }

    public static int countPalindromicSubsequence(String s) {
        int[] count = {0};
        helper(s, count, 0, new HashSet<>(), new StringBuilder());
        return count[0];
    }

    private static void helper(String s, int[] count, int index, HashSet<String> set, StringBuilder sb) {
        if (sb.length() == 3 ) {
            if (sb.charAt(0) == sb.charAt(2) && !set.contains(sb.toString())) {
                count[0] += 1;
                set.add(sb.toString());
            }
            return;
        }

        if (index == s.length()) return;

        sb.append(s.charAt(index));
        helper(s, count, index+1, set, sb);
        sb.deleteCharAt(sb.length()-1);

        helper(s, count, index+1, set, sb);
    }
}
