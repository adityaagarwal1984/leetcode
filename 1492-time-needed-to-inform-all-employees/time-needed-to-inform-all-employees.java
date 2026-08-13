class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<int[]>> ls= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ls.add(new ArrayList<>());
        }
        //int dis[]= new int [n];
       // Arrays.fill(dis,Integer.MAX_VALUE);
       // dis[headID]=0;
        for(int i=0;i<manager.length;i++)
        {
            int m_id= manager[i];
            if(m_id!=-1)
            ls.get(m_id).add(new int[]{i,informTime[m_id]});
        }
        Queue<int[]> que= new LinkedList<>();
        int max= Integer.MIN_VALUE;
        que.offer(new int[]{headID,0});
        while(!que.isEmpty())
        {
            int curr[]= que.poll();
            int node= curr[0];
            int dist= curr[1];
            if(ls.get(node).size()==0)
            {
                max= Math.max(max,dist);
            }
            else
            
            {
                for(int arr[]: ls.get(node))
                {
                    int nei= arr[0];
                    int time= arr[1];
                    que.offer(new int[]{nei,dist+time});
                }
            }
        }
     
     //return max;
     if(max== Integer.MAX_VALUE)
     return -1;
     else
     return max;
    

    }
}