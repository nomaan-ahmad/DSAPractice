package Mathematics;

// https://leetcode.com/problems/count-total-number-of-colored-cells/
public class CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(coloredCells(n));
    }

    public static long coloredCells(int n) {
        long count = 1;
        if (n == 1) return count;

        long incrementer = 0;
        for (int i = 2; i <= n; i++) {
            incrementer += 4;
            count += incrementer;
        }

        return count;
    }
}
