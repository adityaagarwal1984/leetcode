class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<int[]>> ls= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ls.add(new ArrayList<>());
        }
        int dis[]= new int [n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[headID]=0;
        for(int i=0;i<manager.length;i++)
        {
            int m_id= manager[i];
            if(m_id!=-1)
            ls.get(m_id).add(new int[]{i,informTime[m_id]});
        }
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->
        {
            return a[1]-b[1];
        });

        que.offer(new int[]{headID,0});
        while(!que.isEmpty())
        {
            int curr[]= que.poll();
            int node= curr[0];
            int dist= curr[1];
            for(int nei[]: ls.get(node))
            {
                if(dis[nei[0]]> dist+nei[1])
                {
                    dis[nei[0]]= dist+nei[1];
                    que.offer(new int[]{nei[0],dist+nei[1]});
                }
            }
        }
     int max = Integer.MIN_VALUE;
     for(int i=0;i<n;i++)
     {
        max= Math.max(max,dis[i]);
     }
     //return max;
     if(max== Integer.MAX_VALUE)
     return -1;
     else
     return max;
    

    }
}