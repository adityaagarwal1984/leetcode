import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
       // boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});
        //visited[entrance[0]][entrance[1]] = true;
        maze[entrance[0]][entrance[1]]='+';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (maze[nr][nc] == '+') continue;

                // exit condition (not entrance)
                if (nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                    return dist + 1;
                }

                maze[nr][nc] ='+';
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }

        return -1;
    }
}
