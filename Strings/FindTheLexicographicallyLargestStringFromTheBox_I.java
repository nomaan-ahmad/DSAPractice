package Strings;

public class FindTheLexicographicallyLargestStringFromTheBox_I {
    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int wordLen = word.length();
        String result = "";

        int left = 0;
        int right = 1;
        result = word.substring(left, right);

        while (right <= wordLen) {
            if ((right - left - 1 + numFriends) >= wordLen) {
                if (left == right) right++;
                left++;
            }
            else {
                if (right < wordLen) right++;
                else left++;
            }

            if (left == wordLen) break;
            String tempWord = word.substring(left, right);
            if (result.compareTo(tempWord) < 0) result = tempWord;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(answerString("dbca", 2));
    }
}
