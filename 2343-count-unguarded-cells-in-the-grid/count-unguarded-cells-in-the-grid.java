import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n]; 
        // 0 = empty, 1 = guard, 2 = wall, 3 = guarded

        // Mark guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }

        // Mark walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        // Directions: up, down, left, right
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Process each guard
        for (int[] g : guards) {
            for (int[] dir : dirs) {
                int x = g[0] + dir[0];
                int y = g[1] + dir[1];

                while (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 1 || grid[x][y] == 2) {
                        // Stop if another guard or wall is found
                        break;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = 3; // Mark as guarded
                    }
                    x += dir[0];
                    y += dir[1];
                }
            }
        }

        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
