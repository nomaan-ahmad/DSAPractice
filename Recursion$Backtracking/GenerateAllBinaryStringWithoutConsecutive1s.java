package Recursion$Backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem statement: https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/
public class GenerateAllBinaryStringWithoutConsecutive1s {
    public static void main(String[] args) {
        var result = generateAllString(4);

        System.out.println(result);
    }
    public static List<String> generateAllString(int k) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, k);

        return result;
    }

    private static void generate(List<String> result, StringBuilder temp, int index, int k) {
        if (index == k) {
            result.add(temp.toString());
            return;
        }

        temp.append(0);
        generate(result, temp, index+1, k);
        temp.deleteCharAt(index);

        if (index-1 == -1 || temp.charAt(index-1) != '1') {
            temp.append(1);
            generate(result, temp, index+1, k);
            temp.deleteCharAt(index);
        }
    }
}
