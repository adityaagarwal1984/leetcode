class Solution {
    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        
        int[] edge1 = null;
        int[] edge2 = null;

        // Step 1: Check if any node has two parents (indegree == 2)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (inDegree[v] != 0) {
                // Found the node with two parents!
                edge1 = new int[]{inDegree[v], v}; // First parent edge
                edge2 = new int[]{u, v};           // Second parent edge
            } else {
                inDegree[v] = u; // Record incoming parent
            }
        }

        // Initialize DSU
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        // Step 2 & 3: Run DSU (skipping edge2 if it exists)
        for (int[] edge : edges) {
            // Skip edge2 temporarily
            if (edge2 != null && edge[0] == edge2[0] && edge[1] == edge2[1]) {
                continue;
            }

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            // If a cycle is detected:
            if (rootU == rootV) {
                if (edge1 != null) {
                    // Case 3: Both 2 parents & cycle exist -> edge1 is in the cycle
                    return edge1;
                }
                // Case 2: Only cycle exists -> this edge closes the cycle
                return edge;
            }

            parent[rootV] = rootU; // Direct union for directed graph
        }

        // Case 1: No cycle found after skipping edge2 -> edge2 was the redundant edge
        return edge2;
    }

    private int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]); // Path compression
    }
}