package Strings;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class FindUniqueBinaryStrings {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        if (nums.length == 1) {
            return  (nums[0].equals("0")) ? "1" : "0";
        }

        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, nums);

        int bit_size = nums[0].length();
        int max = 1;
        for (int i = 1; i <= bit_size; i++) max = (max << 1);
        max -= 1;

        Random rnd = new Random();

        while (true) {
            int rndNum = rnd.nextInt(max);
            String binStr = numToBinaryStr(rndNum, bit_size);

            if (!set.contains(binStr)) return binStr;
        }
    }

    private static String numToBinaryStr(int n, int bit_size) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            if ((n & 1) == 0) sb.append("0");
            else sb.append("1");

            n = (n >> 1);
        }

        while (sb.length() != bit_size)
            sb.append("0");

        return sb.reverse().toString();
    }
}
