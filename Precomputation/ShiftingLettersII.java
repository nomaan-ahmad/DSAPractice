package Precomputation;

// https://leetcode.com/problems/shifting-letters-ii

public class ShiftingLettersII {
    public static void main(String[] args) {
        String s = "xuwdbdqik";
        int[][] shifts = {{4,8,0},{4,4,0},{2,4,0},{2,4,0},{6,7,1},{2,2,1},{0,2,1},{8,8,0},{1,3,1}};

        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        var arr = s.toCharArray();

        long[] preCompute = new long[s.length()+1];

        for (int[] shift : shifts) {
            if (shift[2] == 0) {
                preCompute[shift[0]] -= 1;
                preCompute[shift[1] + 1] += 1;
            } else {
                preCompute[shift[0]] += 1;
                preCompute[shift[1] + 1] -= 1;
            }
        }

        for (int i = 1; i < preCompute.length; i++) {
            preCompute[i] += preCompute[i-1];
        }

        for (int i = 0; i < arr.length; i++) {
            var aux = ((((arr[i] - 'a') + preCompute[i]) % 26) + 'a');
            arr[i] = (char) ((aux < 'a') ? aux + 26 : aux);
        }

        return new String(arr);
    }
}
