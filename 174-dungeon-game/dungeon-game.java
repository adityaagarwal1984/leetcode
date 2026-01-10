class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m+1][n+1];
        
        // Fill with large values so min() works
        for(int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Base case: need at least 1 HP after the princess
        dp[m][n-1] = dp[m-1][n] = 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                
                int need = Math.min(dp[i+1][j], dp[i][j+1]);
                int required = need - dungeon[i][j];

                dp[i][j] = Math.max(required, 1);
            }
        }

        return dp[0][0];
    }
}
