package Greedy;

// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        char[] arr = ("" + num).toCharArray();
        int n = arr.length;

        // maximizing the num by replacing instances of any digit to make whole number largest
        // logic we will use it to replace all instance of first non-9 digit
        char charToReplace = '-';
        for (char c : arr) {
            if (c != '9') {
                charToReplace = c;
                break;
            }
        }

        if (charToReplace != '-') {
            for (int i = 0; i < n; i++) {
                if (arr[i] == charToReplace) arr[i] = '9';
            }
        }

        int maxNumber = Integer.parseInt(String.valueOf(arr));

        // minimizing the num by replacing instances of any digit to make whole number smallest
        arr = ("" + num).toCharArray();
        charToReplace = '-';
        //int start = arr[0] == '1' ? 1 : 0;

        if (arr[0] == '1') {
            for (int i = 1; i < n; i++) {
                if (arr[i] != '0' && arr[i] != '1') {
                    charToReplace = arr[i];
                    break;
                }
            }

            if (charToReplace != '-') {
                for (int i = 1; i < n; i++) {
                    if (charToReplace == arr[i]) {
                        arr[i] = '0';
                    }
                }
            }
        } else {
            charToReplace = arr[0];
            for (int i = 0; i < n; i++) {
                if (charToReplace == arr[i]) {
                    arr[i] = '1';
                }
            }
        }


        int minNumber = Integer.parseInt(String.valueOf(arr));

        return maxNumber - minNumber;
    }
}
