class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();

        // Step 1: Add all 0s to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Directions for 4 neighbors
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS from all 0s
        while (!que.isEmpty()) {
            int[] cell = que.poll();
            int x = cell[0], y = cell[1];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + 1;
                    que.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return dist;
    }
}
