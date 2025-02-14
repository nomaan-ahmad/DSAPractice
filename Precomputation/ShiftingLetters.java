package Precomputation;

// https://leetcode.com/problems/shifting-letters/description/

public class ShiftingLetters {
    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3,5,9};
        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        long count = 0;

        var arr = s.toCharArray();
        for (int i = shifts.length-1; i >= 0; i--) {
            count += (shifts[i] % 26);

            arr[i] = (char) ('a' + (int)((arr[i] - 'a') + count) % 26);
        }

        return new String(arr);
    }
}
