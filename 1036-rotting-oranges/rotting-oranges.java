import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int fresh = 0;

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        
        if (fresh == 0) return 0;

        int min = -1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!que.isEmpty()) {
            int size = que.size();
            min++;
            for (int k = 0; k < size; k++) {
                int[] pos = que.poll();
                int x = pos[0], y = pos[1];

                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;  
                        fresh--;
                        que.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return fresh == 0 ? min : -1;
    }
}
