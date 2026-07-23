import java.util.*;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // dp[i] stores max earnings possible up to location i
        long[] dp = new long[n + 1];

        // Group rides by their END point (arr[1])
        // Each entry in endRides[i] stores {start, tip} for a ride ending at i
        List<int[]>[] endRides = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            endRides[i] = new ArrayList<>();
        }

        for (int[] ride : rides) {
            int start = ride[0];
            int end = ride[1];
            int tip = ride[2];
            endRides[end].add(new int[]{start, tip});
        }

        for (int i = 1; i <= n; i++) {
            // Option 1: Don't pick any ride ending at i
            dp[i] = dp[i - 1];

            // Option 2: Try ALL rides that end at location i
            for (int[] ride : endRides[i]) {
                int start = ride[0];
                int tip = ride[1];
                long profit = (i - start) + tip;
                
                dp[i] = Math.max(dp[i], dp[start] + profit);
            }
        }

        return dp[n];
    }
}