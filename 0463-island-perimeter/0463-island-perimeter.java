class Solution {
    public int islandPerimeter(int[][] grid) {
         int perimeter = 0;
    int m = grid.length, n = grid[0].length;
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                perimeter += 4;
                // If top neighbor is land, subtract shared border (2 sides)
                if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;
                // If left neighbor is land, subtract shared border (2 sides)
                if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
            }
        }
    }
    return perimeter;

    }
}