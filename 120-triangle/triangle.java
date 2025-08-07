class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] memo = new int[m][];
        for (int i = 0; i < m; i++) {
            memo[i] = new int[i + 1];
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(0, 0, triangle, memo);
    }

    private int dfs(int i, int j, List<List<Integer>> triangle, int[][] memo) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];

        int down = dfs(i + 1, j, triangle, memo);
        int diag = dfs(i + 1, j + 1, triangle, memo);

        return memo[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
    }
}
