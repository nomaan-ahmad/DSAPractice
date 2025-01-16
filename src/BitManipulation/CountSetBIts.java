package BitManipulation;

public class CountSetBIts {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(countSetBits(n));
    }

    private static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
