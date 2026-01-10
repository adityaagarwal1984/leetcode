class Solution {
    int[][][] memo;
    int n;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        memo = new int[n][n][n];

        for (int[][] a : memo)
            for (int[] b : a)
                Arrays.fill(b, Integer.MIN_VALUE);

        int ans = dfs(grid, 0, 0, 0);
        return Math.max(ans, 0);
    }

    private int dfs(int[][] g, int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;  
        if (r1>=n || c1>=n || r2>=n || c2>=n ||
            g[r1][c1] == -1 || g[r2][c2] == -1)
            return -1000000;    
        if (r1 == n-1 && c1 == n-1)
            return g[r1][c1];

        if (memo[r1][c1][r2] != Integer.MIN_VALUE)
            return memo[r1][c1][r2];

        int cherries = g[r1][c1];
        if (r1 != r2 || c1 != c2) 
            cherries += g[r2][c2];

        
        int bestNext = Math.max(
            Math.max(dfs(g, r1+1, c1, r2+1), dfs(g, r1+1, c1, r2)),
            Math.max(dfs(g, r1, c1+1, r2+1), dfs(g, r1, c1+1, r2))
        );

        return memo[r1][c1][r2] = cherries + bestNext;
    }
}
