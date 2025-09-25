class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        Queue<int[]> que= new LinkedList<>();
        int pos[][]={{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || i==m-1 || j==0 || j==n-1)
                {
                    if(board[i][j]=='O')
                    {
                        
                        visited[i][j]=true;
                        que.offer(new int[]{i,j});
                        while(!que.isEmpty())
                        {
                            int a[]= que.poll();
                            int x=a[0];int y=a[1];
                            for(int k=0;k<pos.length;k++)
                            {
                                int u=pos[k][0];
                                int v=pos[k][1];
                                int nx=x+u;
                                int ny=y+v;
                                if(nx>=0 && nx<m && ny>=0 && ny<n &&(!visited[nx][ny]) && board[nx][ny]=='O')
                                {
                                    visited[nx][ny]=true;
                                    que.offer(new int[]{nx,ny});
                                }
                            }
                        }
                        

                    }
                }
            }
        }
for(int i=0;i<m;i++)
{
    for(int j=0;j<n;j++)
    {
        if(!visited[i][j] && board[i][j]=='O')
        board[i][j]='X';

    }
}
        
    }
}