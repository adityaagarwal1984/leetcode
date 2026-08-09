class Solution {
    class node
    {
        int i, j,t;
        node(int x,int y,int ti)
        {
            i=x;
            j=y;
            t=ti;
        }
    }
    static int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
   public int swimInWater(int[][] grid) {
        int ans= Integer.MAX_VALUE;
        int m= grid.length;
        int n= grid[0].length;
        boolean vis[][]= new boolean[m][n];
        PriorityQueue<node> pq = new PriorityQueue<>(
            (x,y)->{
                return x.t- y.t;
                }
        );
        pq.offer(new node(0,0,grid[0][0]));
        vis[0][0]=true;
        while(!pq.isEmpty())
        {
            node curr= pq.poll();
            int row= curr.i;
            int col= curr.j;
            int smay= curr.t;
            if(row==grid.length-1 && col==grid[0].length-1)
            {
                ans= Math.min(ans,smay);
            }
            for(int d[]:dir)
            {
                int new_x=row+d[0];
                int new_y= col+d[1];
                if(new_x>=0 && new_x<m && new_y >=0 && new_y<n && vis[new_x][new_y]==false)
                {
                    // if(grid[new_x][new_y]<=smay)
                    // {   
                    //     vis[new_x][new_y]=true;
                    //     pq.offer(new node(new_x,new_y,smay));
                    // }
                    // else
                    //{
                        int new_time= Math.max(grid[new_x][new_y],smay);
                        vis[new_x][new_y]=true;
                        pq.offer(new node(new_x,new_y,new_time));
                    //}
                }
            }
        }
  return ans;
    }
}