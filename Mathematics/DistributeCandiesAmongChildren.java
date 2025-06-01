package Mathematics;

// https://leetcode.com/problems/distribute-candies-among-children-ii/
public class DistributeCandiesAmongChildren {
    public long distributeCandies(int n, int limit) {
        if (n > 3*limit) return 0;
        long ways = 0;

        long ch1Min = Math.max(0, n - (2*limit));
        long ch1Max = Math.min(n, limit);

        for (long i = ch1Min; i <= ch1Max; i++) {
            long N = n - i;

            long ch2Min = Math.max(0, N - (limit));
            long ch2Max = Math.min(N, limit);

            ways += ch2Max - ch2Min + 1;
        }

        return ways;
    }
}
