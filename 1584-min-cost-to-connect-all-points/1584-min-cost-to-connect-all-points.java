class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int []>> ls= new ArrayList<>();
        for(int i=0;i<points.length;i++)
        {
            ls.add(new ArrayList<>());
        }
        for(int i=0;i< points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int dis= Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]);
                ls.get(i).add(new int[]{j,dis});
                ls.get(j).add(new int[]{i,dis});

            }
        }
       // int ans=0;
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->
        {
            return a[1]-b[1];
        });
        que.offer(new int[]{0,0});
        int vis[]= new int[points.length];
        //vis[0]=1;
        int ans=0;
        int c=0;
        while(!que.isEmpty())
        {
            int curr[]= que.poll();
            int u= curr[0];
            int w= curr[1];
            if(vis[u]==1)
            continue;
            vis[u]=1;
             ans+= w;

            for(int nei[]: ls.get(u))
            {
                que.offer(new int[]{nei[0],nei[1]});
            }
            

        }
        return ans;

    }
}