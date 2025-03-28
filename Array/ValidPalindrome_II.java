package Array;

// https://leetcode.com/problems/valid-palindrome-ii/

public class ValidPalindrome_II {
    public static void main(String[] args) {
        String s = "eceec";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int temp = isPalindrome(s, 0, s.length()-1);

        if (temp != -1) {
            int temp1 = isPalindrome(s, temp, s.length()-temp-2);
            int temp2 = isPalindrome(s, temp+1, s.length()-temp-1);

            return temp1 == -1 || temp2 == -1;
        }
        else return true;
    }

    private static int isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return start;

            start++;
            end--;
        }

        return -1;
    }
}