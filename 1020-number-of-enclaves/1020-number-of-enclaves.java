class Solution {
    public int numEnclaves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int dir[][]={{-1,0},{0,-1},{0,1},{1,0}};
       // int vis[][]= new int[grid.length][grid[0].length];
        Queue<int[]> que= new LinkedList<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 || i==m-1 || j==0 || j==n-1)
                {
                    if(grid[i][j]==1)
                    {
                        //vis[i][j]=1;
                        grid[i][j]=0;
                        que.offer(new int[]{i,j});
                    }
                }
            }
        }
        while(!que.isEmpty())
        {
            int a[]= que.poll();
            int u= a[0];
            int v=a[1];
            for(int d[]:dir)
            {
                int x=u+d[0];
                int y= v+d[1];
                
                if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1)
                {
                   // vis[x][y]=1;
                   grid[x][y]=0;
                    que.offer(new int[]{x,y});
                }
            }
        }
        int c=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                c++;
            }
        }
        return c;
    }
}