package Mathematics;

// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/
public class CheckIfNumberIsASumOfPowerOfThree {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            int rem = n % 3;
            if (rem == 2) return false;
            n /= 3;
        }

        return true;
    }
}
