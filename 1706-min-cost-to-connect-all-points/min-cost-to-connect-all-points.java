class Solution {
    static int rank[];
    static int parent[];
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> ls= new ArrayList<>();
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                if(i!=j)
                {
                    int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    ls.add(new int[]{i,j,dis});
                }
            }
        }
        Collections.sort(ls,(a,b)-> a[2]-b[2]);
        int n= points.length;
        rank= new int[n];
        parent= new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        int c=0;
        int ans=0;
        for(int i=0;i<ls.size();i++)
        {
            if(c==n-1) break;
            int u= ls.get(i)[0];
            int v= ls.get(i)[1];
            if(find(u)==find(v)) continue;
            union(u,v);
            c++;
            ans+=ls.get(i)[2];
        }
        return ans;
    }
    public int find(int node)
    {
        if(parent[node]==node)
        {
            return parent[node];
        }
        int p=find(parent[node]);
        parent[node]=p;
        return parent[node];
    }
    public void union(int u,int v)
    {
        int pu= find(u);
        int pv= find(v);
        if(pu==pv) return;
        if(rank[pu]<rank[pv])
        {
            parent[pu]=pv;
        }
        else if(rank[pv]<rank[pu])
        {
            parent[pv]=pu;
        }
        else
        {
            parent[pu]=pv;
            rank[pv]++;
        }
    }
}