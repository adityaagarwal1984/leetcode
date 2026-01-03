class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // base case: amount 0
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        // base row: using only coins[0]
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {

                int notTake = dp[i-1][j];
                int take = 0;

                if (j >= coins[i])
                    take = dp[i][j - coins[i]];

                dp[i][j] = notTake + take;
            }
        }

        return dp[n - 1][amount];
    }
}
