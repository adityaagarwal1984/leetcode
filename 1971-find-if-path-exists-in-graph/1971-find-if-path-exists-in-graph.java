class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj= new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int arr[]: edges)
        {
            int x= arr[0];
            int y= arr[1];
            adj.get(x).add(y);
            adj.get(y).add(x);

            
        }
        int vis[]= new int[n];

        return dfs(adj,vis,source,destination);
    }
    public boolean dfs(List<List<Integer>> adj, int vis[], int src, int dest)
    {
        if(src==dest) return true;
        vis[src]=1;
        for(int nei: adj.get(src))
        {
            if(vis[nei]==0)
            {
                if(dfs(adj,vis,nei,dest)==true)
                return true;
            }
            
        }
      
        return false;
    }
}