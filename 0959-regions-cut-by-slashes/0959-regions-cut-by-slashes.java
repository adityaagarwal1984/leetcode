class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // Step 1: Create a 3x scale grid
        int[][] expanded = new int[3 * n][3 * n];

        // Step 2: Populate the 3x3 cells according to character
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                
                if (ch == '/') {
                    expanded[i * 3][j * 3 + 2] = 1;
                    expanded[i * 3 + 1][j * 3 + 1] = 1;
                    expanded[i * 3 + 2][j * 3] = 1;
                } else if (ch == '\\') {
                    expanded[i * 3][j * 3] = 1;
                    expanded[i * 3 + 1][j * 3 + 1] = 1;
                    expanded[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        // Step 3: Count connected components using standard DFS / Flood Fill
        int regions = 0;
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (expanded[i][j] == 0) {
                    dfs(expanded, i, j);
                    regions++; // Found a new isolated region
                }
            }
        }

        return regions;
    }

    private void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 0) {
            return;
        }

        grid[r][c] = 1; // Mark as visited (turn into wall)

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}