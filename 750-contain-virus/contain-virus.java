class Solution {
    private int m, n;
    private int[] dirs = {-1, 0, 1, 0, -1};

    public int containVirus(int[][] isInfected) {
        m = isInfected.length;
        n = isInfected[0].length;
        int wallsUsed = 0;

        while (true) {
            List<Set<Integer>> regions = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> wallsNeeded = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];

            // Find all infected regions and their threatened neighbors
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> frontier = new HashSet<>();
                        int[] wallCount = {0};
                        dfs(isInfected, visited, i, j, region, frontier, wallCount);
                        regions.add(region);
                        frontiers.add(frontier);
                        wallsNeeded.add(wallCount[0]);
                    }
                }
            }

            if (regions.isEmpty()) break;

            // Find region that threatens the most uninfected cells
            int maxIdx = 0;
            for (int i = 1; i < frontiers.size(); i++) {
                if (frontiers.get(i).size() > frontiers.get(maxIdx).size()) {
                    maxIdx = i;
                }
            }

            // No region threatens any new cell -> done
            if (frontiers.get(maxIdx).isEmpty()) break;

            wallsUsed += wallsNeeded.get(maxIdx);

            for (int i = 0; i < regions.size(); i++) {
                if (i == maxIdx) {
                    // Quarantine this region permanently (mark as 2)
                    for (int code : regions.get(i)) {
                        int x = code / n, y = code % n;
                        isInfected[x][y] = 2;
                    }
                } else {
                    // Let other regions spread to their frontier cells
                    for (int code : frontiers.get(i)) {
                        int x = code / n, y = code % n;
                        isInfected[x][y] = 1;
                    }
                }
            }
        }

        return wallsUsed;
    }

    private void dfs(int[][] isInfected, boolean[][] visited, int i, int j,
                      Set<Integer> region, Set<Integer> frontier, int[] wallCount) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        if (isInfected[i][j] == 2) return; // already walled off, skip

        if (isInfected[i][j] == 0) {
            frontier.add(i * n + j);
            wallCount[0]++; // one wall per boundary edge to an uninfected cell
            return;
        }

        visited[i][j] = true;
        region.add(i * n + j);

        for (int d = 0; d < 4; d++) {
            dfs(isInfected, visited, i + dirs[d], j + dirs[d + 1], region, frontier, wallCount);
        }
    }
}