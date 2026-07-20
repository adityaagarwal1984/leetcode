import java.util.*;

class Solution {
    // 4-directional movement array mapping: up, right, down, left
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    private int m, n;

    public int containVirus(int[][] isInfected) {
        m = isInfected.length;
        n = isInfected[0].length;
        int totalWalls = 0;

        while (true) {
            boolean[][] visited = new boolean[m][n];
            List<List<int[]>> regions = new ArrayList<>();
            List<Set<Integer>> threatenedLists = new ArrayList<>();
            List<Integer> wallCounts = new ArrayList<>();

            // 1. Find all active infected regions using DFS
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        List<int[]> region = new ArrayList<>();
                        Set<Integer> threatened = new HashSet<>();
                        int[] walls = new int[1]; // Use array wrapper to pass by reference in DFS
                        
                        dfs(i, j, isInfected, visited, region, threatened, walls);
                        
                        regions.add(region);
                        threatenedLists.add(threatened);
                        wallCounts.add(walls[0]);
                    }
                }
            }

            // If there are no active viral regions left, exit the simulation
            if (regions.isEmpty()) break;

            // 2. Identify the region that threatens the most uninfected cells
            int targetRegionIdx = 0;
            for (int i = 1; i < threatenedLists.size(); i++) {
                // Fixed: Using .get(i) instead of bracket array access
                if (threatenedLists.get(i).size() > threatenedLists.get(targetRegionIdx).size()) {
                    targetRegionIdx = i;
                }
            }

            // If the worst region threatens 0 cells, no further virus spreading can happen
            if (threatenedLists.get(targetRegionIdx).isEmpty()) break;

            // 3. Quarantine the most dangerous region (mark cells as 2)
            totalWalls += wallCounts.get(targetRegionIdx);
            for (int[] cell : regions.get(targetRegionIdx)) {
                isInfected[cell[0]][cell[1]] = 2; // 2 means safely isolated
            }

            // 4. Spread all other unquarantined viral regions by 1 step into adjacent 0 cells
            for (int i = 0; i < regions.size(); i++) {
                if (i == targetRegionIdx) continue;
                for (int[] cell : regions.get(i)) {
                    for (int d = 0; d < 4; d++) {
                        int nx = cell[0] + dirs[d];
                        int ny = cell[1] + dirs[d + 1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && isInfected[nx][ny] == 0) {
                            isInfected[nx][ny] = 1;
                        }
                    }
                }
            }
        }

        return totalWalls;
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] visited, 
                     List<int[]> region, Set<Integer> threatened, int[] walls) {
        visited[r][c] = true;
        region.add(new int[]{r, c});

        for (int i = 0; i < 4; i++) {
            int nr = r + dirs[i];
            int nc = c + dirs[i + 1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc, grid, visited, region, threatened, walls);
                } else if (grid[nr][nc] == 0) {
                    walls[0]++; // Count every shared edge requiring a wall
                    threatened.add(nr * n + nc); // Flatten 2D coordinate to uniquely track threatened cells
                }
            }
        }
    }
}