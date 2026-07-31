class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        int ans = 1;

        for (int i = 0; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int x = 0; x <= k; x++) {
                int max = 1; // base case: subsequence starting at i
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j]) {
                        max = Math.max(max, 1 + dp[j][x]);
                    } else if (x > 0) {
                        max = Math.max(max, 1 + dp[j][x - 1]);
                    }
                }
                dp[i][x] = max;
                ans = Math.max(ans, dp[i][x]); // track overall max
            }
        }

        return ans;
    }
}