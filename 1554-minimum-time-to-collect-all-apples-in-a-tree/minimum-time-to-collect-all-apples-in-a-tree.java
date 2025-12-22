class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); // undirected tree
        }

        boolean[] visited = new boolean[n];
        return dfs(0, adj, hasApple, visited);
    }

    private int dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    List<Boolean> hasApple, boolean[] visited) {
        visited[node] = true;
        int time = 0;

        for (int child : adj.get(node)) {
            if (!visited[child]) {
                int childTime = dfs(child, adj, hasApple, visited);

                
                if (childTime > 0 || hasApple.get(child)) {
                    time += childTime + 2;
                }
            }
        }
        return time;
    }
}
