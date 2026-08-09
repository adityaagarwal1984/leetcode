class Graph {
    List<List<int[]>> ls;
    int no;
    public Graph(int n, int[][] edges) {
        ls= new ArrayList<>();
        no=n;
        for(int i=0;i<n;i++)
        {
            ls.add(new ArrayList<>());
        }
        for(int a[]: edges)
        {
            int x= a[0];
            int y= a[1];
            int w= a[2];
            ls.get(x).add(new int[]{y,w});
        }
    }
    
    public void addEdge(int[] edge) {
         ls.get(edge[0]).add(new int[]{edge[1],edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int dis[]= new int[no];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[node1]=0;
        PriorityQueue<int[]> que= new PriorityQueue<>(
            (a,b)->
            { 
                return a[1]-b[1];
            }
        );
        que.offer(new int[]{node1,0});
        while(!que.isEmpty())
        {
            int curr[]= que.poll();
            int nei_node= curr[0];
            int nei_wei= curr[1];
            for(int nei[]: ls.get(curr[0]))
            {
                if(nei[1]+nei_wei< dis[nei[0]])
                {
                    dis[nei[0]]= nei[1]+nei_wei;
                    que.offer(new int[]{nei[0],nei[1]+nei_wei});
                }
            }
        }
        if(dis[node2]!= Integer.MAX_VALUE)
        return dis[node2];
        else
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */