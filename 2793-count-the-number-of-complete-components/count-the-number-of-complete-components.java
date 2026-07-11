class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans=0;
        List<List<Integer>> adj= new ArrayList<>();
        int vis[]= new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i]==1)
            continue;
            int arr[]= new int[1];
            int nodes= solve(adj, vis,arr,i);
            int edge= arr[0];
            if((int)(nodes*(nodes-1))== edge)
            ans++;
        }
     return ans;
    }
    public int solve(List<List<Integer>> adj,int vis[],int arr[],int i)
    {
        int nodes=0;
        if(vis[i]==1)
        return 0;
        vis[i]=1;
        nodes+=1;
        arr[0]+= adj.get(i).size();
        for(int nei: adj.get(i))
        {
            if(vis[nei]==0)
            {
                nodes+=solve(adj,vis,arr,nei);
            }
        }
        return nodes;
    }
}