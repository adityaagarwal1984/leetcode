class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer> comp= new ArrayList<>();
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        long sum=0;
        for(int a[]: edges)
        {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        Set<Integer> vis= new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(vis.contains(i)) continue;
            int size= dfs(i,vis,adj);
            comp.add(size);
            sum+= size;
        }
     if(comp.size()==1)   return 0;
     long curr=0;
     for(int num: comp)
     {
    long rem= sum-num;
        curr+= rem*num;
     }
     return curr/2;

    }
    public int dfs(int node, Set<Integer> set, List<List<Integer>> adj)
    {
        set.add(node);
        int size=0;
        size++;
        for(int nei: adj.get(node))
        {
            if(!set.contains(nei))
            {
                size+= dfs(nei,set,adj);
            }
        }
        return size;
    }
}