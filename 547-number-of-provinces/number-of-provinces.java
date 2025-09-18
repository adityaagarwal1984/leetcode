class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        int vis[]= new int[v];
        int c=0;

        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
            c++;
            dfs(i,isConnected,vis);
            }
        }
        return c;

        
    }
    public  void dfs(int node ,int [][] adj,int vis[])
    {
         vis[node]=1;
        for(int j=0;j<adj.length;j++)
        {
            if(adj[node][j]==1 && vis[j]==0)
            dfs(j,adj,vis);
        }
    }
}