import java.util.*;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        
        // Step 1: Build the Adjacency List -> u -> List of (v, time)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Step 2: Min-Heap ordered by total cost ascending
        // PriorityQueue Stores: {cost, time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // minTime[i] stores the minimum time taken to reach node i so far
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        // Initialize with starting node (node 0)
        pq.offer(new int[]{passingFees[0], 0, 0});
        minTime[0] = 0;
        
        // Step 3: Dijkstra Loop
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int currTime = curr[1];
            int u = curr[2];
            
            // Reached destination -> Guaranteed minimum cost due to Min-Heap!
            if (u == n - 1) {
                return currCost;
            }
            
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int travelTime = neighbor[1];
                
                int nextTime = currTime + travelTime;
                int nextCost = currCost + passingFees[v];
                
                // Only proceed if within maxTime limit AND improves time for node v
                if (nextTime <= maxTime && nextTime < minTime[v]) {
                    minTime[v] = nextTime;
                    pq.offer(new int[]{nextCost, nextTime, v});
                }
            }
        }
        
        return -1; // Unreachable within maxTime
    }
}