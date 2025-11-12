class Solution {
    public int[] findOrder(int c, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<c;i++)
        {
            adj.add(new ArrayList<>());
        }
        int indeg[]= new int[c];
        for(int i=0;i<arr.length;i++)
        {
            int u=arr[i][1];
            int v=arr[i][0];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> que= new LinkedList<>();
        for(int i=0;i<indeg.length;i++)
        {
            if(indeg[i]==0)
            que.add(i);
        }
        List<Integer> ans= new ArrayList<>();
        while(!que.isEmpty())
        {
            int node=que.poll();
            ans.add(node);
            for(int num:adj.get(node))
            {
                indeg[num]--;
                if(indeg[num]==0)
                que.offer(num);
            }
        }
        int a[]= new int[c];
        if(ans.size()!=c)
        return new int[]{};
        int i=0;
        for(int num:ans)
        {
            a[i++]=num;
        }
        return a;
        
       

        
    }
}