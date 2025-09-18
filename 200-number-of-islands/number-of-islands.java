class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j,grid.length,grid[0].length,grid);
                    c++;
                }
            }
        }
        return c;

        
    }
    public void dfs(int i,int j,int m,int n,char arr[][])
    {
        if(i<0 || j<0 || i>=m|| j>=n|| arr[i][j]=='0'|| arr[i][j]=='2')
        return;
        arr[i][j]='2';
        dfs(i-1,j,m,n,arr);
        dfs(i+1,j,m,n,arr);
        dfs(i,j+1,m,n,arr);
        dfs(i,j-1,m,n,arr);


    }
}
