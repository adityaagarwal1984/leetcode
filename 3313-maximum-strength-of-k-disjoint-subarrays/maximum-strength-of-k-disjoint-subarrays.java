import java.util.Arrays;

class Solution {
    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j][0] -> not extending
        // dp[i][j][1] -> extending
        long[][][] dp = new long[n + 1][k + 1][2];
        
        // Initialize everything with negative infinity
        long INF = (long) 1e18;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -INF;
                dp[i][j][1] = -INF;
            }
        }
        
        // Base case: 0 elements and 0 subarrays has a strength of 0
        dp[0][0][0] = 0;

        for (int i = 1; i <= n; i++) {
            long val = nums[i - 1];
            
            // Base transition: 0 subarrays formed up to element i
            dp[i][0][0] = 0;

            for (int j = 1; j <= Math.min(k, i); j++) {
                long coeff = k - j + 1;
                long weight = (j % 2 == 1) ? coeff * val : -coeff * val;

                // 1. Not including nums[i-1] in the j-th subarray
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);

                // 2. Including nums[i-1] in the j-th subarray
                // Choice A: Start a new subarray of size 1
                long startNew = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
                
                // Choice B: Extend the existing j-th subarray
                long extendExisting = dp[i - 1][j][1];

                long maxPrev = Math.max(startNew, extendExisting);
                
                if (maxPrev != -INF) {
                    dp[i][j][1] = maxPrev + weight;
                }
            }
        }

        // Return the best of ending on an element or finishing earlier
        return Math.max(dp[n][k][0], dp[n][k][1]);
    }
}