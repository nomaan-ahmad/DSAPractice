package Hashing;

public class MinLengthOfStringAfterOperations {
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        int result = 0;
        int[] freq = new int[26];
        for(byte c: s.getBytes()) freq[c - 'a']++;

        for (int count : freq) {
            if (count > 2) {
                if (count % 2 == 0) result += 2;
                else result++;
            } else result += count;
        }

        return result;
    }
}
